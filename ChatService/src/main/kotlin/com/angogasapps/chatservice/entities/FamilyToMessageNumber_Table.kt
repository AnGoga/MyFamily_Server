package com.angogasapps.chatservice.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "family_to_message_number_table")
@Entity
class FamilyToMessageNumber_Table(
    @Id
    @Column(name = "family_id")
    var familyId: String = "",
    @Column(name = "message_number")
    var messageNumber: Long = 0
) {}