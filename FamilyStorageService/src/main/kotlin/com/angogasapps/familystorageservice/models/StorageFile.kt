package com.angogasapps.familystorageservice.models

import com.angogasapps.familystorageservice.enums.EFamilyStorageType
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "StorageFile")
@DiscriminatorValue("StorageFile")
data class StorageFile(
    @Id
    override var id: String = "",
    override var name: String = "",
    var value: String = "",
    override var familyId: String = "",
    @Column(name = "root_folder_id")
    override var rootFolderId: String? = null,
    override var storageType: EFamilyStorageType? = null
) : StorageObject(id, name, familyId, rootFolderId, storageType) {
//    override val type: StorageObjectType = StorageObjectType.TYPE_FILE
    override fun isFile(): Boolean = true
    override fun isFolder(): Boolean = false
}