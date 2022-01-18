package com.angogasapps.chatservice.services

import com.angogasapps.chatservice.entities.FamilyToMessageNumber_Table
import com.angogasapps.chatservice.entities.Message
import com.angogasapps.chatservice.models.ChatPagingRequest
import com.angogasapps.chatservice.repositories.ChatRepository
import com.angogasapps.chatservice.repositories.MessageNumbersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.security.InvalidParameterException

@Service
class ChatService {
    @Autowired
    private lateinit var repository: ChatRepository
    @Autowired
    private lateinit var numbersRepository: MessageNumbersRepository
    @Autowired
    private lateinit var notifier: ChatNotifier

    fun getMoreMessages(m: ChatPagingRequest): MutableList<Message> {
        return if (m.fromMessage.number == -1L) {
            repository.getMoreMessageFromBottom(familyId = m.familyId, count = m.count)
        } else if (m.fromMessage.number >= 0L) {
            repository.getMoreMessages(familyId = m.familyId, count = m.count, oldId = m.fromMessage.number)
        } else
            throw InvalidParameterException("Message id must be bigger that -2! But have count = ${m.fromMessage.number}")
    }

    fun postMessage(message: Message) {
        val number = getAndIncrement(message)//numbersRepository.getAndIncrement(message.familyId)
        repository.save(message.also { it.number = number; it.time = System.currentTimeMillis() })
        notifier.sendMessage(message)
    }

    private fun getAndIncrement(message: Message): Long {
        var number = 0L
        synchronized(ChatService::class) {
            val numberObj = numbersRepository.findByIdOrNull(message.familyId)
            if (numberObj == null) {
                numbersRepository.save(FamilyToMessageNumber_Table(familyId = message.familyId, messageNumber = 0))
            } else {
                number = 1 + numberObj.messageNumber
                numbersRepository.save(FamilyToMessageNumber_Table(familyId = message.familyId, messageNumber = number))
            }
        }
        return number
    }
}