package com.angogasapps.myfamily.repositories

import com.angogasapps.myfamily.entities.Family
import org.springframework.stereotype.Repository

@Repository
class FamilyRepository {

    fun getFamily(id: String): Family {
        return Family()//.also { it.members["myIdUser_ygdyg"] = ERoles.creator }
    }

}