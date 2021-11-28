package com.angogasapps.buylistservice.entities

import javax.persistence.*

@Entity
@Table(name = "buy_list")
data class BuyList(
    @Id
    @Column(name = "id")
    var id: String = "",
    @Column(name = "title")
    var title: String = "",
    @OneToMany
    @Column(name = "products")
    @JoinColumn(name = "buyList_id")
    var products: MutableList<Product> = ArrayList()
)
