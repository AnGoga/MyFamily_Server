package com.angogasapps.mediastorageservice.utils

import com.angogasapps.mediastorageservice.enums.EMediaType

const val NODE_IMAGE_STORAGE = "image_storage"
const val NODE_FILE_STORAGE = "file_storage"
const val NODE_VIDEO_STORAGE = "video_storage"
const val NODE_NOTE_STORAGE = "note_storage"

fun EMediaType.toStorageType(): String {
    return when(this){
        EMediaType.STORAGE_IMAGE -> NODE_IMAGE_STORAGE
        EMediaType.STORAGE_NOTE -> NODE_NOTE_STORAGE
        EMediaType.STORAGE_FILE -> NODE_FILE_STORAGE
        EMediaType.STORAGE_VIDEO -> NODE_VIDEO_STORAGE
        else -> throw Exception("Can't cast this EMediaType (\"${this}\") to storage type string!")
    }
}