package com.angogasapps.buylistservice.repositories

import com.angogasapps.buylistservice.entities.BuyList
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface BuyListRepository : CrudRepository<BuyList, String> {
    @Modifying
    @Query("update BuyList b set b.title = :title where b.id = :id")
    fun updateBuyListName(@Param("id") id: String, @Param("title") name: String)
}