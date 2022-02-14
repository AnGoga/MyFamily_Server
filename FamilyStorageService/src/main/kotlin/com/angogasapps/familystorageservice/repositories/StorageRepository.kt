package com.angogasapps.familystorageservice.repositories

import com.angogasapps.familystorageservice.enums.EFamilyStorageType
import com.angogasapps.familystorageservice.models.StorageObject
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StorageRepository : CrudRepository<StorageObject, String> {
    fun findAllByRootFolderIdAndFamilyIdAndStorageType(
        rootFolderId: String?,
        familyId: String,
        storageType: EFamilyStorageType
    ): MutableList<StorageObject>
}





//
//@Repository
//interface StorageRepository : AbstractStorageRepository {
//    @Transactional
//    fun getContent(familyId: String, storageType: StorageType): StorageFolder {
//        val list = findAllByRootFolderIdAndFamilyIdAndStorageType(ROOT_FOLDER_ID, familyId, storageType)
//        return StorageFolder(id = ROOT_FOLDER_ID, name = ROOT_FOLDER_ID, familyId = familyId, value = list)
//    }
//}
//
//interface AbstractStorageRepository : CrudRepository<StorageObject, String> {
//    fun findAllByRootFolderIdAndFamilyIdAndStorageType(
//        rootFolderId: String,
//        familyId: String,
//        storageType: StorageType
//    ): MutableList<StorageObject>
//}
//
