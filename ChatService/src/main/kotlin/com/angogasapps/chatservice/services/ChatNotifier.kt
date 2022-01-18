package com.angogasapps.chatservice.services

import com.angogasapps.chatservice.entities.Message
import com.angogasapps.chatservice.models.ChatEvent
import com.angogasapps.chatservice.models.EChatEvent
import com.angogasapps.chatservice.models.MessageEventResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class ChatNotifier {
    @Autowired
    private lateinit var messagingTemplate: SimpMessagingTemplate

    fun sendMessage(message: Message) {
        val event = MessageEventResponse(ChatEvent(message = message, event = EChatEvent.added))
//        println("send to -> \"/topic/chats/families/${message.familyId}/rooms/main/broadcast\"")
        messagingTemplate.convertAndSend("/topic/chats/families/${message.familyId}/rooms/main/broadcast", event)
    }
}