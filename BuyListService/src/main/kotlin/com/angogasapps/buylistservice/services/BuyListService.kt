package com.angogasapps.buylistservice.services

import com.angogasapps.buylistservice.entities.BuyList
import com.angogasapps.buylistservice.entities.Product
import com.angogasapps.buylistservice.repositories.BuyListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BuyListService {
    @Autowired
    private lateinit var buyListRepository: BuyListRepository

    fun createBuyList(familyId: String, buyList: BuyList) {
        buyListRepository.save(buyList)
    }

    fun deleteBuyList(familyId: String, buyListId: String) {
        buyListRepository.deleteById(buyListId)
        //TODO: remove all products from this buylist
    }

    fun updateBuyListName(buyListId: String, newName: String) {

    }

    fun createProduct(buyListId: String, productId: String, product: Product) {

    }

    fun updateProduct(buyListId: String, productId: String, product: Product) {

    }

    fun deleteProduct(buyListId: String, productId: String) {

    }
}