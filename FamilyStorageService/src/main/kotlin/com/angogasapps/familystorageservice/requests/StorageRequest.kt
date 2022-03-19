package com.angogasapps.familystorageservice.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class StorageRequest(
    val id: String = "",
    val name: String = "",
    val value: String = "",
    val rootNode: String = "",
    val rootFolder: String = "",
)
//: CreateFolderRequest(name = name, rootNode = rootNode, rootFolder = rootFolder, id = id)