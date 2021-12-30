package com.angogasapps.buylistservice.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import javax.persistence.*

//@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
@Entity
@Table(name = "buy_list")
data class BuyList(
    @Id
    @Column(name = "id")
    var id: String = "",
    @Column(name = "title")
    var title: String = "",
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "products")
    var products: MutableList<Product> = ArrayList()
) {
//    constructor(): this(id = "", title = "", products = ArrayList())
}
