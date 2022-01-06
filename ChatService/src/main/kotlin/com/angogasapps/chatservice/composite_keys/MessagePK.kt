package com.angogasapps.chatservice.composite_keys

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


class MessagePK(
    var familyId: String = "",
    var id: Long = 0
) : Serializable {
    constructor() : this("", 0) {}
}