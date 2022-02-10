package com.angogasapps.familystorageservice.utils

import com.angogasapps.familystorageservice.enums.StorageType


const val NODE_IMAGE_STORAGE = "image_storage"
const val NODE_FILE_STORAGE = "file_storage"
const val NODE_VIDEO_STORAGE = "video_storage"
const val NODE_NOTE_STORAGE = "note_storage"


fun String.toStorageType() : StorageType =
    when(this.lowercase()) {
        NODE_IMAGE_STORAGE -> StorageType.IMAGE_STORAGE
        NODE_FILE_STORAGE -> StorageType.FILE_STORAGE
        NODE_NOTE_STORAGE -> StorageType.NOTE_STORAGE
        NODE_VIDEO_STORAGE -> StorageType.VIDEO_STORAGE
        else -> throw IllegalArgumentException("This string \"${this}\" not is StorageType")
    }