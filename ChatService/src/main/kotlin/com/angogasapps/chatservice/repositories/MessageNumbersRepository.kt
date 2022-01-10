package com.angogasapps.chatservice.repositories

import com.angogasapps.chatservice.entities.FamilyToMessageNumber_Table
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface MessageNumbersRepository : CrudRepository<FamilyToMessageNumber_Table, String> {

//    @Modifying
    @Query(
        value = """
        DO $$
        DECLARE this_num int8;
        BEGIN
            SELECT s.message_number
            INTO this_num
            FROM family_to_message_number_table AS s
            WHERE s.family_id = :family_id_param;
            IF NOT FOUND THEN
                SET this_num = 0;
            END IF;
            
            INSERT INTO family_to_message_number_table
            VALUES (:family_id_param, this_num + 1)
            ON CONFLICT (family_id) DO UPDATE 
                SET message_number = this_num + 1;
                
            RETURN this_num;
        END $$;
        """,
        nativeQuery = true
    )
    fun getAndIncrement(@Param("family_id_param") id: String): Long
}