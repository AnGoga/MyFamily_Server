package com.angogasapps.familystorageservice.utils

import com.angogasapps.familystorageservice.enums.EFamilyStorageType


const val NODE_IMAGE_STORAGE = "image_storage"
const val NODE_FILE_STORAGE = "file_storage"
const val NODE_VIDEO_STORAGE = "video_storage"
const val NODE_NOTE_STORAGE = "note_storage"


fun String.toStorageType() : EFamilyStorageType =
    when(this.lowercase()) {
        NODE_IMAGE_STORAGE -> EFamilyStorageType.IMAGE_STORAGE
        NODE_FILE_STORAGE -> EFamilyStorageType.FILE_STORAGE
        NODE_NOTE_STORAGE -> EFamilyStorageType.NOTE_STORAGE
        NODE_VIDEO_STORAGE -> EFamilyStorageType.VIDEO_STORAGE
        else -> throw IllegalArgumentException("This string \"${this}\" not is StorageType")
    }