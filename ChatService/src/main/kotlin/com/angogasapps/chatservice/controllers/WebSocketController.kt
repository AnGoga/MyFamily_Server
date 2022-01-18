package com.angogasapps.chatservice.controllers

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class WebSocketController {

    @MessageMapping("/chats/families/{family_id}/rooms/{room_id}/broadcast")
    @SendTo("/chats/families/{family_id}/rooms/{room_id}/broadcast")
    fun echo() {}
}