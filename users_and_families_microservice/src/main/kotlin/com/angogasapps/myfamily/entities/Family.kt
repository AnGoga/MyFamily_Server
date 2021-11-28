package com.angogasapps.myfamily.entities

import com.angogasapps.myfamily.enums.ERoles
import javax.persistence.*

@Entity
@Table(name = "families")
data class Family(
    @Id
    @Column(name = "id")
    var id: String = "",
    @Column(name = "name")
    var name: String = "",
    @Column(name = "emblem_url")
    var emblemUrl: String = "",
    @ElementCollection
    @Column(name = "members")
    var members: MutableMap<String, ERoles> = HashMap()
)
