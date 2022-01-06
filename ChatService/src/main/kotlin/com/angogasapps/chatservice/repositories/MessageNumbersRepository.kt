package com.angogasapps.chatservice.repositories

import com.angogasapps.chatservice.entities.FamilyToMessageNumber_Table
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MessageNumbersRepository : CrudRepository<FamilyToMessageNumber_Table, String> {}