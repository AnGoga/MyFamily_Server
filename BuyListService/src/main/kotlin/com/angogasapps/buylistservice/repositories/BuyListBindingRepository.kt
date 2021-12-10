package com.angogasapps.buylistservice.repositories

import com.angogasapps.buylistservice.entities.BuyListIdsBinding
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BuyListBindingRepository : CrudRepository<BuyListIdsBinding, String> {

    @Modifying
    @Query("select b.buy_list_id from buy_list_ids_binding b where b.family_id = :family_id", nativeQuery = true)
    fun findAllByFamilyId(@Param("family_id") familyId: String): MutableList<String>
}