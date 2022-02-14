package com.angogasapps.mediastorageservice.models

import com.angogasapps.mediastorageservice.enums.EMediaType

data class MediaFileInfo(
    var id: String = "",
    val type: EMediaType = EMediaType.NOTHING,
    val familyId: String = "",
    val familyStorageFolderId: String = "",
//    val storageType: String = ""
)