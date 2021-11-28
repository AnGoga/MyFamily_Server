package com.angogasapps.myfamily.services

import com.angogasapps.myfamily.entities.Family
import com.angogasapps.myfamily.repositories.FamilyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FamilyService {
    @Autowired
    private lateinit var familyRepository: FamilyRepository

    fun joinToFamily(familyId: String, userId: String) {

    }

    fun createFamily(family: Family) {

    }

    fun getFamily(familyId: String): Family {
        val family = familyRepository.getFamily(familyId)
        return family
    }
}