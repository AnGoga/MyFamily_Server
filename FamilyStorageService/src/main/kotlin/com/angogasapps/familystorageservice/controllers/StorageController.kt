package com.angogasapps.familystorageservice.controllers

import com.angogasapps.familystorageservice.models.StorageFolder
import com.angogasapps.familystorageservice.requests.StorageRequest
import com.angogasapps.familystorageservice.services.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/family_storage/data/families/{familyId}/data/{storageType}")
class StorageController {
    @Autowired
    private lateinit var service: StorageService

    @GetMapping("/content")
    fun getStorageContent(
        @PathVariable familyId: String,
        @PathVariable storageType: String
    ): StorageFolder {
        return service.getStorageContent(familyId, storageType)
    }

    @PostMapping("/create/folder")
    fun createFolder(
        @PathVariable familyId: String,
        @PathVariable storageType: String,
        @RequestBody request: StorageRequest
    ): String {
        return service.createFolder(familyId = familyId, request = request, storageType = storageType)
    }

    @PostMapping("/create/file")
    fun createFile(
        @PathVariable familyId: String,
        @PathVariable storageType: String,
        @RequestBody request: StorageRequest
    ): String {
        val fileId = service.createFile(familyId = familyId, request = request, storageType = storageType)
        return fileId
    }

    @DeleteMapping("/remove/file")
    fun removeFile(
        @PathVariable familyId: String,
        @PathVariable storageType: String,
        @RequestBody info: StorageRequest
    ) {
        service.removeFile(info)
    }

    @DeleteMapping("/remove/folder")
    fun removeFolder(
        @PathVariable familyId: String,
        @PathVariable storageType: String,
        @RequestBody info: StorageRequest
    ): List<String> {
        return service.removeFolder(info)
    }
}