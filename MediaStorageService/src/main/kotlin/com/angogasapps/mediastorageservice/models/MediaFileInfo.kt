package com.angogasapps.mediastorageservice.models

import com.angogasapps.mediastorageservice.enums.EMediaType

data class MediaFileInfo(
    val id: String = "",
    val type: EMediaType = EMediaType.NOTHING,
    val familyId: String = ""
)