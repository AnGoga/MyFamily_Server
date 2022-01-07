package com.angogasapps.chatservice.repositories

import com.angogasapps.chatservice.composite_keys.MessagePK
import com.angogasapps.chatservice.entities.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface ChatRepository : CrudRepository<Message, MessagePK> {

    @Transactional
    @Modifying
    @Query(
        value = """
        SELECT *
        FROM messages
        WHERE number_field < :old_id AND family_id = :family_id_param
        ORDER BY number_field DESC
        LIMIT :counts
    """, nativeQuery = true
    )
    fun getMoreMessages(
        @Param("old_id") oldId: Long,
        @Param("family_id_param") familyId: String,
        @Param("counts") count: Int
    ): MutableList<Message>

}