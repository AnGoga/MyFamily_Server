package com.angogasapps.chatservice.controllers

import com.angogasapps.chatservice.entities.Message
import com.angogasapps.chatservice.services.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/chat/families/{familyId}/rooms/main/messages")
class MessageController {
    @Autowired
    private lateinit var service: ChatService


    @PostMapping("/post")
    fun postMessage(@PathVariable familyId: String, @RequestBody message: Message) {
        service.postMessage(message = message)
    }

    @GetMapping("/get_more")
    fun getMoreMessages(@RequestBody message: Message): MutableList<Message> {
        val list = service.getMoreMessages(message)
        list.size
        return list
    }
}