package com.angogasapps.buylistservice.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "buy_list_ids_binding")
data class BuyListIdsBinding(
    @Id
    @Column(name = "buy_list_id", nullable = false)
    var buyListId: String,
    @Column(name = "family_id", nullable = false)
    var familyId: String = ""
)