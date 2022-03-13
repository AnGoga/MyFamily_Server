package com.angogasapps.mediastorageservice.repositories

import com.angogasapps.mediastorageservice.models.MediaFileInfo
import com.angogasapps.mediastorageservice.services.CommunicationService
import com.angogasapps.mediastorageservice.utils.toStorageType
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import kotlin.io.path.deleteIfExists


@Repository
class MediaStorageRepository {
    private val root: Path //= Paths.get("C:/Java/IT_school_project/project/server_dir/media/images")
    private val absolutePath: String


    init {
        val path = File("").absolutePath
        absolutePath = "$path\\media_storage\\storage"
        root = Paths.get(absolutePath)
        createPath(root)
    }

    fun saveFile(file: MultipartFile, info: MediaFileInfo, extraStr: String?): String {
        val id = info.id.ifEmpty { UUID.randomUUID().toString() }
        val path = Paths.get(absolutePath + info.type.buildPath(info)).also { createPath(it) }
        Files.copy(file.inputStream, path.resolve(id))
        return id
    }

    fun getMediaFile(info: MediaFileInfo): Resource {
        val file = Paths.get(absolutePath + info.type.buildPath(info)).resolve(info.id)
        val resource = UrlResource(file.toUri())
        return if (resource.exists() || resource.isReadable)
            resource
        else
            throw RuntimeException("Could not read the file!")
    }

    private fun createPath(path: Path) {
        if (!Files.exists(path)) Files.createDirectories(path)
    }


    fun removeFile(info: MediaFileInfo) {
        val file = Paths.get(absolutePath + info.type.buildPath(info)).resolve(info.id)
        file.deleteIfExists()
    }

    fun removeFolders(listIds: List<String>, info: MediaFileInfo) {
        val rootFolder = Paths.get(absolutePath + info.type.buildPath(info)).parent
        listIds.forEach {
            rootFolder.resolve(it).deleteIfExists()
        }
    }


}