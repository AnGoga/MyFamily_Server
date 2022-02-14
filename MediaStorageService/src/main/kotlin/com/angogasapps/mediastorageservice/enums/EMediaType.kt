package com.angogasapps.mediastorageservice.enums

import com.angogasapps.mediastorageservice.intefaces.Pathable
import com.angogasapps.mediastorageservice.models.MediaFileInfo

enum class EMediaType: Pathable {
    NOTHING {
        override fun buildPath(fileInfo: MediaFileInfo) = throw Exception("NOTHING haven't path!")
    },
    CHAT_IMAGE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\chat\\${fileInfo.familyId}\\image_message"
    },
    CHAT_VOICE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\chat\\${fileInfo.familyId}\\voice_message"
    },
    CHAT_FILE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\chat\\${fileInfo.familyId}\\file_message"
    },
    USER_IMAGE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\users_data\\users_photos\\"
    },
    STORAGE_IMAGE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\family_storage\\${fileInfo.familyId}\\images_storage\\${fileInfo.familyStorageFolderId}"
    },
    STORAGE_NOTE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\family_storage\\${fileInfo.familyId}\\notes_storage\\${fileInfo.familyStorageFolderId}"
    },
    STORAGE_FILE {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\family_storage\\${fileInfo.familyId}\\files_storage\\${fileInfo.familyStorageFolderId}"
    },
    STORAGE_VIDEO {
        override fun buildPath(fileInfo: MediaFileInfo) = "\\family_storage\\${fileInfo.familyId}\\videos_storage\\${fileInfo.familyStorageFolderId}"
    }
}