package com.angogasapps.familystorageservice.models

import com.angogasapps.familystorageservice.enums.EFamilyStorageType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "StorageObject_Type")
@JsonIgnoreProperties(value = arrayOf("folder", /*"file",*/ "rootFolderId", "familyId", "storageType"))
abstract class StorageObject(
    @Id
    open var id: String = "",
    open var name: String = "",
    open var familyId: String = "",
    @Column(name = "root_folder_id")
    open var rootFolderId: String? = null,
    open var storageType: EFamilyStorageType? = null
) {

    abstract fun isFile(): Boolean
    abstract fun isFolder(): Boolean


}
