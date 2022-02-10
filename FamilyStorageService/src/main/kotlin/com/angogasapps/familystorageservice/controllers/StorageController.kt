package com.angogasapps.familystorageservice.controllers

import com.angogasapps.familystorageservice.enums.StorageType
import com.angogasapps.familystorageservice.models.StorageFolder
import com.angogasapps.familystorageservice.models.StorageObject
import com.angogasapps.familystorageservice.requests.CreateFileRequest
import com.angogasapps.familystorageservice.requests.CreateFolderRequest
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
        @RequestBody request: CreateFolderRequest
    ) {
        service.createFolder(familyId = familyId, request = request, storageType = storageType)
    }

    @PostMapping("/create/file")
    fun createFile(
        @PathVariable familyId: String,
        @PathVariable storageType: String,
        @RequestBody request: CreateFileRequest
    ) {
        service.createFile(familyId = familyId, request = request, storageType = storageType)
    }

}