package com.angogasapps.familystorageservice.services

import com.angogasapps.familystorageservice.enums.StorageType
import com.angogasapps.familystorageservice.models.StorageFile
import com.angogasapps.familystorageservice.models.StorageFolder
import com.angogasapps.familystorageservice.models.StorageObject
import com.angogasapps.familystorageservice.repositories.StorageRepository
import com.angogasapps.familystorageservice.requests.CreateFileRequest
import com.angogasapps.familystorageservice.requests.CreateFolderRequest
import com.angogasapps.familystorageservice.utils.ROOT_FOLDER_ID
import com.angogasapps.familystorageservice.utils.toStorageType
import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.*


@Service
class StorageService {
    @Autowired
    private lateinit var eurekaClient: EurekaClient

    @Autowired
    private lateinit var storageRepository: StorageRepository

    fun getStorageContent(
        familyId: String,
        storageType: String
    ): StorageFolder {
        val list = storageRepository.findAllByRootFolderIdAndFamilyIdAndStorageType(
            null,
            familyId,
            storageType.toStorageType()
        )
        return StorageFolder(id = ROOT_FOLDER_ID, name = ROOT_FOLDER_ID, familyId = familyId, value = list)

    }

    fun createFolder(familyId: String, request: CreateFolderRequest, storageType: String): String {
        val id = UUID.randomUUID().toString()
        val folder =
            StorageFolder(id = id, name = request.name, familyId = familyId, rootFolderId = request.rootFolder).also {
                it.storageType = storageType.toStorageType()
                if (it.rootFolderId == "") it.rootFolderId = null
            }
        storageRepository.save(folder)
        return id
    }

    fun createFile(familyId: String, request: CreateFileRequest, storageType: String): String {
        val id = UUID.randomUUID().toString()
        val file = StorageFile(
            id = id,
            name = request.name,
            familyId = familyId,
            value = request.value,
            rootFolderId = request.rootFolder
        ).also {
            it.storageType = storageType.toStorageType()
            if (it.rootFolderId == "") it.rootFolderId = null
        }
        storageRepository.save(file)
        return id
    }
}