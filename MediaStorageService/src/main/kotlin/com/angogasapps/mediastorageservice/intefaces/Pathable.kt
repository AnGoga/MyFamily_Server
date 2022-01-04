package com.angogasapps.mediastorageservice.intefaces

import com.angogasapps.mediastorageservice.models.MediaFileInfo

interface Pathable {
    fun buildPath(fileInfo: MediaFileInfo): String
}