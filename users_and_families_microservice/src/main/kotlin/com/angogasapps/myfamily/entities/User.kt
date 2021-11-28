package com.angogasapps.myfamily.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id")
    var id: String = "",
    @Column(name = "phone")
    var phone: String = "",
    @Column(name = "name")
    var name: String = "",
    @Column(name = "family_id")
    var familyId: String = "",
    @Column(name = "birthday")
    var birthday: Long = 0,
    @Column(name = "photo_url")
    var photoUrl: String = ""
)
