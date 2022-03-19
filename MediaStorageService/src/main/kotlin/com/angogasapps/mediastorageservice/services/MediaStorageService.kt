package com.angogasapps.mediastorageservice.services

import com.angogasapps.mediastorageservice.models.MediaFileInfo
import com.angogasapps.mediastorageservice.models.MediaResponse
import com.angogasapps.mediastorageservice.repositories.MediaStorageRepository
import com.angogasapps.mediastorageservice.utils.toStorageType
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.ArrayList

@Service
class MediaStorageService {
    private val objectMapper = ObjectMapper()
    @Autowired
    private lateinit var repository: MediaStorageRepository
    @Autowired
    private lateinit var communicationService: CommunicationService

    fun uploadFile(file: MultipartFile, info: MediaFileInfo, extraStr: String?): MediaResponse {
        val id = repository.saveFile(file, info, extraStr)
        info.id = id
        if (info.isFamilyStorageFile()) {
            saveInFamilyStorageService(info, extraStr)
        }
        val response = MediaResponse(
            MediaFileInfo(
                id = id,
                type = info.type,
                familyId = info.familyId,
                rootFolder = info.rootFolder
            )
        )
        return response
    }

    fun getMediaFile(info: MediaFileInfo): Resource {
        return repository.getMediaFile(info)
    }

    fun removeFile(info: MediaFileInfo) {
        repository.removeFile(info)
        if (info.isFamilyStorageFile()) {
            removeFileFromFamilyStorage(info)
        }
    }

    fun removeFolder(info: MediaFileInfo) {
        val listIds = removeFolderFromFamilyStorage(info)
        repository.removeFolders(listIds, info)
    }


    private fun removeFolderFromFamilyStorage(info: MediaFileInfo): List<String> {
        return communicationService.requestToFamilyStorage(
            info = info,
            path = "family_storage/data/families/${info.familyId}/data/${info.type.toStorageType()}/remove/folder"
        ).let { objectMapper.readValue(it.body, object : TypeReference<ArrayList<String>>() {}) }
            .orEmpty()
    }

    private fun removeFileFromFamilyStorage(info: MediaFileInfo) {
        communicationService.requestToFamilyStorage(
            info = info,
            path = "family_storage/data/families/${info.familyId}/data/${info.type.toStorageType()}/remove/file"
        )
    }

    private fun saveInFamilyStorageService(info: MediaFileInfo, extraStr: String?) {
        val response = communicationService.requestToFamilyStorage(
            info,
            extraStr,
            "family_storage/data/families/${info.familyId}/data/${info.type.toStorageType()}/create/file"
        )
        info.id = response.body!!
    }

}