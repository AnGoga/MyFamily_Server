package com.angogasapps.chatservice.entities

import com.angogasapps.chatservice.composite_keys.MessagePK
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

@Entity
@Table
@IdClass(MessagePK::class)
data class Message(
    @Id
    @Column(nullable = false)
    @GenericGenerator(
        name = "chat-sequence",
        strategy = "com.angogasapps.chatservice.key_generators.MyGenerator"
    )
    @GeneratedValue(generator = "chat-sequence")
    var id: Long = 0,

    @Id
    @Column(nullable = false)
    var familyId: String = "",

    @Column(name = "field_from")
    var from: String = "",
    var type: String = "",
    var time: Long = 0,
    var value: String = "",
): Serializable