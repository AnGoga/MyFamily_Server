package com.angogasapps.familystorageservice.utils

import com.angogasapps.familystorageservice.enums.EFamilyStorageType


const val NODE_IMAGE_STORAGE = "image_storage"
const val NODE_FILE_STORAGE = "file_storage"
const val NODE_VIDEO_STORAGE = "video_storage"
const val NODE_NOTE_STORAGE = "note_storage"


fun String.toStorageType() : EFamilyStorageType =
    when(this.lowercase()) {
        NODE_IMAGE_STORAGE -> EFamilyStorageType.STORAGE_IMAGE
        NODE_FILE_STORAGE -> EFamilyStorageType.STORAGE_FILE
        NODE_NOTE_STORAGE, "storage_note" -> EFamilyStorageType.STORAGE_NOTE
        NODE_VIDEO_STORAGE -> EFamilyStorageType.STORAGE_VIDEO
        else -> throw IllegalArgumentException("This string \"${this}\" not is StorageType")
    }