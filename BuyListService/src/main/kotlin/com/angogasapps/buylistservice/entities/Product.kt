package com.angogasapps.buylistservice.entities

import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @Column(name = "id")
    var id: String = "",
    @Column(name = "title")
    var title: String = "",
    @Column(name = "comment")
    var comment: String = "",
    @ElementCollection
    @Column(name = "image_url")
    var imageUrl: MutableList<String> = ArrayList()
)
