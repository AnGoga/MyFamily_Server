package com.angogasapps.chatservice.services

import com.angogasapps.chatservice.entities.FamilyToMessageNumber_Table
import com.angogasapps.chatservice.entities.Message
import com.angogasapps.chatservice.repositories.ChatRepository
import com.angogasapps.chatservice.repositories.MessageNumbersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ChatService {
    @Autowired
    private lateinit var repository: ChatRepository

    @Autowired
    private lateinit var numbersRepository: MessageNumbersRepository

    fun getMoreMessages(m: Message): MutableList<Message> {
        val list = repository.getMoreMessages(familyId = m.familyId, oldId = m.number, count = 20)
        return list
    }

    fun postMessage(message: Message) {
        val number = getAndIncrement(message)//numbersRepository.getAndIncrement(message.familyId)
        repository.save(message.also { it.number = number })
    }

    private fun getAndIncrement(message: Message): Long {
        var number = 0L;
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