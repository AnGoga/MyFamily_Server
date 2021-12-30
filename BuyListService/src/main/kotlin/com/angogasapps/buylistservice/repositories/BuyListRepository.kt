package com.angogasapps.buylistservice.repositories

import com.angogasapps.buylistservice.entities.BuyList
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface BuyListRepository : CrudRepository<BuyList, String> {
    @Modifying
    @Transactional
    @Query("update BuyList b set b.title = :title where b.id = :id")
    fun updateBuyListName(@Param("id") id: String, @Param("title") name: String)

}