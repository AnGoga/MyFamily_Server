package com.angogasapps.chatservice.entities

import com.angogasapps.chatservice.composite_keys.MessagePK
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "MESSAGE_TABLE")
@IdClass(MessagePK::class)
data class Message(
    @Id
    @Column(nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    var number: Long = 0,
    @Id
    @Column(name = "family_id",nullable = false)
    var familyId: String = "",

    @Column(name = "field_from")
    var from: String = "",
    var type: String = "",
    var time: Long = 0,
    var value: String = "",
): Serializable