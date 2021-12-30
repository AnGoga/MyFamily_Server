package com.angogasapps.buylistservice.controllers

import com.angogasapps.buylistservice.entities.BuyList
import com.angogasapps.buylistservice.services.BuyListService
import com.angogasapps.buylistservice.values.PATH_BUY_LIST_LISTENER
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class RealTimeController {
    @Autowired
    private lateinit var buyListService: BuyListService

//    @MessageMapping("/post")
//    @SendTo("$PATH_BUY_LIST_LISTENER/{family_id}")
//    fun eho(string: String): String {
//        return string
//    }

    @SubscribeMapping("/buy_lists/changes/{familyId}")
    fun onSubscribe(@Payload(required = false) body: String?, @DestinationVariable familyId: String): MutableList<BuyList> {
        return buyListService.getAllBuyLists(familyId)
    }
}