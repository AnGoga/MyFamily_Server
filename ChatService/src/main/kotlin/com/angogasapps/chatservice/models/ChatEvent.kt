package com.angogasapps.chatservice.models

import com.angogasapps.chatservice.entities.Message

data class ChatEvent(val event: EChatEvent, val message: Message){}

enum class EChatEvent {
    added, changed, removed
}