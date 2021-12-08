package com.angogasapps.buylistservice.services

import com.angogasapps.buylistservice.entities.BuyList
import com.angogasapps.buylistservice.entities.Product
import com.angogasapps.buylistservice.repositories.BuyListRepository
import com.angogasapps.buylistservice.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BuyListService {
    @Autowired
    private lateinit var buyListRepository: BuyListRepository
    @Autowired
    private lateinit var productRepository: ProductRepository

    fun createBuyList(familyId: String, buyList: BuyList) {
        buyList.products.forEach { it.buyListId = buyList.id }
        buyListRepository.save(buyList)
    }

    fun deleteBuyList(familyId: String, buyListId: String) {
        buyListRepository.deleteById(buyListId)
        productRepository.deleteAllByBuyListId(buyListId)
    }

    fun updateBuyListName(buyListId: String, newName: String) {
        buyListRepository.updateBuyListName(id = buyListId, name = newName)
    }

    fun createProduct(buyListId: String, productId: String, product: Product) {
        product.buyListId = buyListId
        productRepository.save(product)
    }

    fun updateProduct(buyListId: String, productId: String, product: Product) {
//        productRepository.updateProductStats(productId, product.title, product.comment)
        productRepository.save(product)
    }

    fun deleteProduct(buyListId: String, productId: String) {
        productRepository.deleteById(productId)
    }

    fun getAllBuyLists(familyId: String) {
        //TODO: create table for binds families and buyLists
    }
}