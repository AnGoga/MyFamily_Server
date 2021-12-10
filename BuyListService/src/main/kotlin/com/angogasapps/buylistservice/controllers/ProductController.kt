package com.angogasapps.buylistservice.controllers

import com.angogasapps.buylistservice.entities.Product
import com.angogasapps.buylistservice.services.BuyListService
import com.angogasapps.buylistservice.values.PATH_BUY_LISTS
import com.angogasapps.buylistservice.values.PATH_BUY_LIST_LISTENER
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {
    @Autowired
    private lateinit var buyListService: BuyListService

    @PostMapping("$PATH_BUY_LISTS/{familyId}/{buyListId}/{productId}")
    fun createProduct(
        @PathVariable familyId: String,
        @PathVariable buyListId: String,
        @PathVariable productId: String,
        @RequestParam(value = "product") product: Product
    ) {
        buyListService.createProduct(familyId, buyListId, productId, product)
    }

    @DeleteMapping("$PATH_BUY_LISTS/{familyId}/{buyListId}/{productId}")
    fun deleteProduct(
        @PathVariable familyId: String,
        @PathVariable buyListId: String,
        @PathVariable productId: String
    ) {
        buyListService.deleteProduct(familyId, buyListId, productId)
    }

    @PatchMapping("$PATH_BUY_LISTS/{familyId}/{buyListId}/{productId}")
    fun updateProduct(
        @PathVariable familyId: String,
        @PathVariable buyListId: String,
        @PathVariable productId: String,
        @RequestBody product: Product
    ) {
        buyListService.updateProduct(familyId, buyListId, productId, product)
    }
}