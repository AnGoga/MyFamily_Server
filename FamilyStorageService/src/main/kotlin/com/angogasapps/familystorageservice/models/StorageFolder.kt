package com.angogasapps.familystorageservice.models

import com.angogasapps.familystorageservice.enums.EFamilyStorageType
import javax.persistence.*

@Entity(name = "StorageFolder")
@DiscriminatorValue("StorageFolder")
data class StorageFolder(
    @Id
    override var id: String = "",
    override var name: String = "",
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "root_folder_id")
    var value: MutableList<StorageObject> = ArrayList(),
    override var familyId: String = "",
    @Column(name = "root_folder_id")
    override var rootFolderId: String? = null,
    override var storageType: EFamilyStorageType? = null
) : StorageObject(id, name, familyId, rootFolderId, storageType) {
//    override val type: StorageObjectType = StorageObjectType.TYPE_FOLDER

    override fun isFile(): Boolean = false
    override fun isFolder(): Boolean = true
}