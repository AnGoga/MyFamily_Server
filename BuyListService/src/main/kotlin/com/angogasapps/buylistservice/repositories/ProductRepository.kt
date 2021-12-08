package com.angogasapps.buylistservice.repositories

import com.angogasapps.buylistservice.entities.Product
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : CrudRepository<Product, String> {
    @Modifying
    @Query("delete from Product p where p.buyListId =: buy_list_id")
    fun deleteAllByBuyListId(@Param("buy_list_id") buy_list_id: String)

    @Modifying
    @Query("update Product p set p.title =: title, p.comment =: comment where p.id =: id")
    fun updateProductStats(@Param("id") id: String, @Param("title") title: String, @Param("comment") comment: String)
}