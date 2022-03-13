package com.angogasapps.familystorageservice.repositories

import com.angogasapps.familystorageservice.enums.EFamilyStorageType
import com.angogasapps.familystorageservice.models.StorageFolder
import com.angogasapps.familystorageservice.models.StorageObject
import com.angogasapps.familystorageservice.requests.StorageRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
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



//@Repository
//class StorageRepository {
//    @Autowired
//    private lateinit var queryRepository: StorageQueryRepository
//
//    fun getIdsAndRemoveFolder(request: StorageRequest): List<String> {
//        val entity = queryRepository.findById(request.id).get()
//        val listIds = (entity as StorageFolder).getNestedFolderIds()
//        queryRepository.deleteById(request.id)
//        return listIds
//    }
//
//}





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
