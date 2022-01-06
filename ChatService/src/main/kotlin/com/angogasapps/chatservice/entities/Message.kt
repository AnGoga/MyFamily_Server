package com.angogasapps.chatservice.entities

import com.angogasapps.chatservice.composite_keys.MessagePK
import java.io.Serializable
import javax.persistence.*

@Entity
@Table
@IdClass(MessagePK::class)
data class Message(
    @Id
    @Column(nullable = false)
    var familyId: String = "",

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    var id: Long = 0,

    @Column(name = "field_from")
    var from: String = "",
    var type: String = "",
    var time: Long = 0,
    var value: String = "",
): Serializable