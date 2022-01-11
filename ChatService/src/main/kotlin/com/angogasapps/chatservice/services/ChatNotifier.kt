package com.angogasapps.chatservice.services

import com.angogasapps.chatservice.entities.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class ChatNotifier {
    @Autowired
    private lateinit var messagingTemplate: SimpMessagingTemplate

    fun sendMessage(message: Message) {
        messagingTemplate.convertAndSend("/chats/families/${message.familyId}/rooms/main/broadcast")
    }
}