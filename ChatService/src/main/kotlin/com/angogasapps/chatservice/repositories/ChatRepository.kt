package com.angogasapps.chatservice.repositories

import com.angogasapps.chatservice.composite_keys.MessagePK
import com.angogasapps.chatservice.entities.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ChatRepository : PagingAndSortingRepository<Message, MessagePK> {

    @Query(
        value = """
        SELECT m
        FROM message_table m
        WHERE m.number < :old_id AND m.family_id = :family_id
        ORDER BY m.number DESC
        LIMIT :counts
    """, nativeQuery = true
    )
    fun getMoreMessages(
        @Param("old_id") oldId: Long,
        @Param("family_id") familyId: String,
        @Param("counts") count: Int
    ): MutableList<Message>

}