package com.angogasapps.mediastorageservice.models

import com.angogasapps.mediastorageservice.enums.EMediaType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MediaFileInfo(
    var id: String = "",
    val name: String = "",
    val value: String = "",
    val rootFolder: String = "",
    val rootNode: String = "",
    val type: EMediaType = EMediaType.NOTHING,
    val familyId: String = "",
//    val storageType: String = ""
) {
    fun isFamilyStorageFile() = (type == EMediaType.STORAGE_FILE ||
            type == EMediaType.STORAGE_IMAGE ||
            type == EMediaType.STORAGE_NOTE ||
            type == EMediaType.STORAGE_VIDEO)
}