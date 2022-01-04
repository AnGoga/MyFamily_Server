package com.angogasapps.mediastorageservice.repositories

import com.angogasapps.mediastorageservice.models.MediaFileInfo
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Repository
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*


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

    fun saveFile(file: MultipartFile, info: MediaFileInfo): String {
        val id = UUID.randomUUID().toString()
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

}