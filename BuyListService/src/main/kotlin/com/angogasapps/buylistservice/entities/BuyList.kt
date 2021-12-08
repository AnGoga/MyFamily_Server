package com.angogasapps.buylistservice.entities

import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import javax.persistence.*

@Entity
@Table(name = "buy_list")
data class BuyList(
    @Id
    @Column(name = "id")
    var id: String = "",
    @Column(name = "title")
    var title: String = "",
    @OneToMany(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "products")
    @JoinColumn(name = "buy_list_id")
    var products: MutableList<Product> = ArrayList()
)
