package com.angogasapps.chatservice.key_generators

import com.angogasapps.chatservice.entities.Message
import org.hibernate.Session
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import java.io.Serializable
/*
class MyGenerator : IdentifierGenerator  {
    override fun generate(session: SharedSessionContractImplementor?, obj: Any?): Serializable? {
        return if (obj is Message) {
            val s = session as Session
            val id = obj.id
            var sequences = s.get(Sequences::class.java, id) as Sequences
            var next: Long = 1
            if (sequences == null) {
                sequences = Sequences(id, next)
            } else {
                next = sequences.getNext() + 1
                sequences.setNext(next)
            }
            s.saveOrUpdate(sequences)
            "$id-$next"
        } else {
            null
        }
    }
}*/