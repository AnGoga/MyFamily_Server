package com.angogasapps.mediastorageservice.controllers

import com.angogasapps.mediastorageservice.entities.ImageControllerResponse
import com.angogasapps.mediastorageservice.repositories.ImageStorageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController()
@RequestMapping("media_storage/media/images")
class ImageController {
    @Autowired
    private lateinit var repository: ImageStorageRepository

    @PostMapping(value = ["/upload"], produces = [MediaType.IMAGE_JPEG_VALUE]/*, consumes = ["multipart/form-data"]*/)
    fun uploadJPEGImage(@RequestParam("file") file: MultipartFile): ImageControllerResponse {
        val id = repository.save(file)
        val url = "http://192.168.1.11:8092/media_storage/media/images/get/${id}"
        val response = ImageControllerResponse(imageUrl = url)
        return response
    }

    @GetMapping(value = ["/get/{id}"])
    fun getImage(@PathVariable id: String): Resource {
        val resource = repository.getImage(id)
        return resource
    }
}