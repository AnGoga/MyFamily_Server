package com.angogasapps.chatservice.repositories

import com.angogasapps.chatservice.composite_keys.MessagePK
import com.angogasapps.chatservice.entities.Message
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatRepository : PagingAndSortingRepository<Message, MessagePK> {

}