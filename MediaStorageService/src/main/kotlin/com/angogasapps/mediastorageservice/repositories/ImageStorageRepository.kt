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
class ImageStorageRepository {
    private val root: Path //= Paths.get("C:/Java/IT_school_project/project/server_dir/media/images")

    init {
        val path = File("").absolutePath
        root = Paths.get("$path\\media\\images")
        if (!Files.exists(root.parent))
            Files.createDirectory(root.parent)
        if (!Files.exists(root))
            Files.createDirectory(root)
    }

    fun save(file: MultipartFile, info: MediaFileInfo): String {
        val id = UUID.randomUUID().toString()
        Files.copy(file.inputStream, root.resolve(id))
        return id
    }

    fun getImage(id: String): Resource {
        val file = root.resolve(id)
        val resource = UrlResource(file.toUri())

        return if (resource.exists() || resource.isReadable)
            resource
        else
            throw RuntimeException("Could not read the file!")
    }

}