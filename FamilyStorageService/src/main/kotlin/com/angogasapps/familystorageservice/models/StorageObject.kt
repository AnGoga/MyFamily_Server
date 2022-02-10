package com.angogasapps.familystorageservice.models

import com.angogasapps.familystorageservice.enums.StorageObjectType
import com.angogasapps.familystorageservice.enums.StorageType
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "StorageObject_Type")
abstract class StorageObject(
    @Id
    open var id: String = "",
    open var name: String = "",
    open var familyId: String = "",
    @Column(name = "root_folder_id")
    open var rootFolderId: String? = null,
    open var storageType: StorageType? = null
) {

//    abstract val type: StorageObjectType
    abstract fun isFile(): Boolean
    abstract fun isFolder(): Boolean


}
