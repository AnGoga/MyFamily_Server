package com.angogasapps.buylistservice.services

import com.angogasapps.buylistservice.enums.EBuyListEvents
import com.angogasapps.buylistservice.entities.BuyList
import com.angogasapps.buylistservice.models.ChangeMessage
import com.angogasapps.buylistservice.values.PATH_BUY_LIST_LISTENER
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class BuyListChangesNotifier {
    @Autowired
    private lateinit var messagingTemplate: SimpMessagingTemplate

    fun notifyChange(familyId: String, event: EBuyListEvents, buyList: BuyList) {
        val message = ChangeMessage(event, buyList)
        messagingTemplate.convertAndSend("$PATH_BUY_LIST_LISTENER/${familyId}", message)
    }
}
