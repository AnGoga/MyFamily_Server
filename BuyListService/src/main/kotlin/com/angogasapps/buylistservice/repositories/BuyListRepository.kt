package com.angogasapps.buylistservice.repositories

import com.angogasapps.buylistservice.entities.BuyList
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BuyListRepository : CrudRepository<BuyList, String> {

}