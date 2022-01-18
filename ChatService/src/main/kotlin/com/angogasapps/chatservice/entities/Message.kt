package com.angogasapps.chatservice.entities

import com.angogasapps.chatservice.composite_keys.MessagePK
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonSetter
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "messages")
@IdClass(MessagePK::class)
data class Message(
    @Id
    @Column(name = "number_field", nullable = false)
    @JsonAlias("id")
    @JsonSetter("id")
    var number: Long = 0,
    @Id
    @Column(name = "family_id",nullable = false)
    var familyId: String = "",

    @Column(name = "from_field")
    var from: String = "",
    @Column(name = "type_field")
    var type: String = "",
    @Column(name = "time_field")
    var time: Long = 0,
    @Column(name = "value_field")
    var value: String = "",
)