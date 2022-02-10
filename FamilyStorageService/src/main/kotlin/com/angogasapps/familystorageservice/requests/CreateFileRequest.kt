package com.angogasapps.familystorageservice.requests

class CreateFileRequest(
    name: String,
    val value: String,
    rootNode: String,
    rootFolder: String,
): CreateFolderRequest(name = name, rootNode = rootNode, rootFolder = rootFolder)