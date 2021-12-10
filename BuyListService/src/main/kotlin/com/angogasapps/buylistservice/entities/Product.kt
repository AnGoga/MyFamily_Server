package com.angogasapps.buylistservice.entities

import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
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
    @Column(name = "buy_list_id")
    var buyListId: String = "",
    @ElementCollection
    @Column(name = "image_url")
    var imageUrls: MutableList<String> = ArrayList()
)
