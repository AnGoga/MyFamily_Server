package com.angogasapps.familystorageservice.requests

open class CreateFolderRequest(
    val name: String,
    val rootNode: String = "",
    val rootFolder: String = ""
)