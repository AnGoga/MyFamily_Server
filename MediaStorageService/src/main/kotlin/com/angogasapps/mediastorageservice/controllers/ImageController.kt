package com.angogasapps.mediastorageservice.controllers

import com.angogasapps.mediastorageservice.entities.ImageControllerResponse
import com.angogasapps.mediastorageservice.models.MediaFileInfo
import com.angogasapps.mediastorageservice.models.MediaResponse
import com.angogasapps.mediastorageservice.repositories.ImageStorageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController()
@RequestMapping("media_storage/media/images")
class ImageController {
    @Autowired
    private lateinit var repository: ImageStorageRepository

    @PostMapping(value = ["/upload"])//, /*produces = [MediaType.IMAGE_JPEG_VALUE]*//*, consumes = ["multipart/form-data"]*/)
    fun uploadJPEGImage(@RequestParam("file") file: MultipartFile, @RequestParam("info") info: MediaFileInfo): MediaResponse {
        val id = repository.save(file, info)
//        val url = "http://192.168.1.11:8092/media_storage/media/images/get/${id}"

        val response = MediaResponse(MediaFileInfo(id = id))
        return response
    }

    @GetMapping(value = ["/get"], produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getImage(@RequestBody info: MediaFileInfo): Resource {
        val resource = repository.getImage(info.id)
        return resource
    }
}