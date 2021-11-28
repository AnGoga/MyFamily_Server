package com.angogasapps.buylistservice.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RestController


@RestController
class RealTimeController {
    @Autowired
    private lateinit var messagingTemplate: SimpMessagingTemplate

}