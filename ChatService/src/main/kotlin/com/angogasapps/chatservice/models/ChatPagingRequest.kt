package com.angogasapps.chatservice.models

import com.angogasapps.chatservice.entities.Message

class ChatPagingRequest(
    val familyId: String = "",
    val count: Int = 0,
    val fromMessage: Message = Message(number = -2),
)