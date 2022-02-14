package com.angogasapps.mediastorageservice.controllers

import com.angogasapps.mediastorageservice.enums.EMediaType
import com.angogasapps.mediastorageservice.models.MediaFileInfo
import com.angogasapps.mediastorageservice.models.MediaResponse
import com.angogasapps.mediastorageservice.repositories.MediaStorageRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files

@RestController
@RequestMapping("media_storage/media/storage")
class ImageController {
    @Autowired
    private lateinit var repository: MediaStorageRepository
    private val objectMapper = ObjectMapper()

    @PostMapping(value = ["/upload"])// consumes = ["multipart/form-data", "application/json"])//, /*produces = [MediaType.IMAGE_JPEG_VALUE]*/
    fun uploadFile(
        @RequestPart("file") file: MultipartFile,
        @RequestPart("info") infoStr: String,
        @RequestPart("extra", required = false) extraStr: String?
    ): MediaResponse {
        val info: MediaFileInfo = objectMapper.readValue(infoStr, MediaFileInfo::class.java)
        val id = repository.saveFile(file, info, extraStr)
        val response = MediaResponse(
            MediaFileInfo(
                id = id,
                type = info.type,
                familyId = info.familyId,
                familyStorageFolderId = info.familyStorageFolderId
            )
        )
        return response
    }

    @PostMapping(value = ["/get/file"]) //consumes = ["application/octet-stream", "application/json"])//, produces = [MediaType.IMAGE_JPEG_VALUE])  MediaType.APPLICATION_OCTET_STREAM_VALUE
    fun getMediaFile(@RequestBody info: MediaFileInfo): ResponseEntity<ByteArray> {
        val resource = repository.getMediaFile(info)

        return ResponseEntity.ok()
//            .contentType(MediaType.parseMediaType(MediaType.MULTIPART_FORM_DATA_VALUE))
//            .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
            .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
//            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + info.id + "\"")
            .body(Files.readAllBytes(resource.file.toPath()))
//            .body(resource)
    }

    @PostMapping(value = ["/get/image"]) //, produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getJPEGImage(@RequestBody info: MediaFileInfo): ResponseEntity<ByteArray> {
        val resource = repository.getMediaFile(info)
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
            .body(Files.readAllBytes(resource.file.toPath()))
    }

    @GetMapping(value = ["/get/image/families/{familyId}/types/{type}/ids/{id}"])
    fun getJPEGImageByParams(
        @PathVariable(value = "familyId") familyId: String,
        @PathVariable(value = "type") type: String,
        @PathVariable(value = "id") id: String
    ): ResponseEntity<ByteArray> {
        val info = MediaFileInfo(id = id, familyId = familyId, type = EMediaType.valueOf(type))
        return getJPEGImage(info)
    }
}