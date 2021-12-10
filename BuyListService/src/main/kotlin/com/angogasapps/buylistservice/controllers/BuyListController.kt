package com.angogasapps.buylistservice.controllers

import com.angogasapps.buylistservice.entities.BuyList
import com.angogasapps.buylistservice.exceptions.EqualsIdException
import com.angogasapps.buylistservice.services.BuyListService
import com.angogasapps.buylistservice.values.PATH_BUY_LISTS
import com.angogasapps.buylistservice.values.PATH_BUY_LIST_LISTENER
import com.angogasapps.buylistservice.values.PATH_TOPIC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*
import javax.xml.bind.JAXBElement


@RestController
class BuyListController {
    @Autowired
    private lateinit var buyListService: BuyListService

    @PostMapping("${PATH_BUY_LISTS}/{familyId}/{buyListId}")
    fun createBuyList(
        @PathVariable(value = "familyId") familyId: String,
        @PathVariable(value = "buyListId") buyListId: String,
        @RequestBody buyList: BuyList
    ) {
        if (buyList.id != buyListId)
            throw EqualsIdException("buylist ids in path($buyListId) and in object(${buyList.id}) not equals")
        println(buyList)
        buyList.id = buyListId
        buyListService.createBuyList(familyId, buyList)

    }

    @DeleteMapping("${PATH_BUY_LISTS}/{familyId}/{buyListId}")
    fun deleteBuyList(@PathVariable familyId: String, @PathVariable buyListId: String) {
        buyListService.deleteBuyList(familyId, buyListId)
    }

    @PatchMapping("${PATH_BUY_LISTS}/{familyId}/{buyListId}")
    fun updateBuyListName(
        @PathVariable familyId: String,
        @PathVariable buyListId: String,
        @RequestParam(value = "name") newName: String
    ) {
        buyListService.updateBuyListName(familyId, buyListId, newName)
    }

    @GetMapping("${PATH_BUY_LISTS}/{familyId}")
    fun getAllBuyLists(@PathVariable familyId: String): MutableList<BuyList> {
        val list = buyListService.getAllBuyLists(familyId)
        return list
    }

}