package com.angogasapps.mediastorageservice.models

import com.angogasapps.mediastorageservice.enums.EMediaType

data class MediaFileInfo(
    var id: String = "",
    val type: EMediaType = EMediaType.NOTHING,
    val familyId: String = "",
    val familyStorageFolderId: String = "",
//    val storageType: String = ""
) {
    fun isFamilyStorageFile() = (type == EMediaType.STORAGE_FILE ||
            type == EMediaType.STORAGE_IMAGE ||
            type == EMediaType.STORAGE_NOTE ||
            type == EMediaType.STORAGE_VIDEO)
}