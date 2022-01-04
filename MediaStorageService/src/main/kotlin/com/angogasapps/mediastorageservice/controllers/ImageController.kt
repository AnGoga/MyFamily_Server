package com.angogasapps.mediastorageservice.controllers

import com.angogasapps.mediastorageservice.models.MediaFileInfo
import com.angogasapps.mediastorageservice.models.MediaResponse
import com.angogasapps.mediastorageservice.repositories.MediaStorageRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController()
@RequestMapping("media_storage/media/storage")
class ImageController {
    @Autowired
    private lateinit var repository: MediaStorageRepository

    @PostMapping(value = ["/upload"])// consumes = ["multipart/form-data", "application/json"])//, /*produces = [MediaType.IMAGE_JPEG_VALUE]*/
    fun uploadJPEGImage(@RequestParam("file") file: MultipartFile, @RequestParam("info") infoStr: String): MediaResponse {
        val info: MediaFileInfo = ObjectMapper().readValue(infoStr, MediaFileInfo::class.java)
        val id = repository.saveFile(file, info)
        val response = MediaResponse(MediaFileInfo(id = id, type = info.type, familyId = info.familyId))
        return response
    }

    @GetMapping(value = ["/get"])//, produces = [MediaType.IMAGE_JPEG_VALUE])  MediaType.APPLICATION_OCTET_STREAM_VALUE
    fun getMediaFile(@RequestBody info: MediaFileInfo): ResponseEntity<Resource> {
        val resource = repository.getMediaFile(info)
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(MediaType.MULTIPART_FORM_DATA_VALUE))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.filename + "\"")
            .body(resource)
    }
}