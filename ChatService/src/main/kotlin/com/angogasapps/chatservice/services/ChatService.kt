package com.angogasapps.chatservice.services

import com.angogasapps.chatservice.entities.Message
import com.angogasapps.chatservice.repositories.ChatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class ChatService {
    @Autowired
    private lateinit var repository: ChatRepository

    fun getMessages(m: Message) {
//        val pageable = PageRequest.of()
    }

    fun postMessage(familyId: String, message: Message) {
        repository.save(message)
    }
}