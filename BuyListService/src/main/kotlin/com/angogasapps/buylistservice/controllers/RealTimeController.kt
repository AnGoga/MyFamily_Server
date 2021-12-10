package com.angogasapps.buylistservice.controllers

import com.angogasapps.buylistservice.values.PATH_BUY_LIST_LISTENER
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RestController


@RestController
class RealTimeController {
    @Autowired
    private lateinit var messagingTemplate: SimpMessagingTemplate

    @MessageMapping("/post")
    @SendTo("$PATH_BUY_LIST_LISTENER/{family_id}")
    fun eho(string: String): String {
        return string
    }
}