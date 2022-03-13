package com.angogasapps.familystorageservice.requests

class StorageRequest(
    val id: String = "",
    val name: String = "",
    val value: String = "",
    val rootNode: String = "",
    val rootFolder: String = "",
)
//: CreateFolderRequest(name = name, rootNode = rootNode, rootFolder = rootFolder, id = id)