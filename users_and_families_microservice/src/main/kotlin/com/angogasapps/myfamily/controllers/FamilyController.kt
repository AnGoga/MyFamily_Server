package com.angogasapps.myfamily.controllers

import com.angogasapps.myfamily.entities.Family
import com.angogasapps.myfamily.repositories.FamilyRepository
import com.angogasapps.myfamily.services.FamilyService
import com.angogasapps.myfamily.values.PATH_FAMILIES
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class FamilyController {
    @Autowired
    private lateinit var familyService: FamilyService

    @PostMapping("${PATH_FAMILIES}/{familyId}")
    fun createFamily(@PathVariable familyId: String, @RequestParam(value = "family") family: Family) {
        familyService.createFamily(family)
    }

    @PostMapping("${PATH_FAMILIES}/{familyId}/joinToFamily")
    fun joinToFamily(@PathVariable familyId: String, @RequestParam(value = "user_id") userId: String) {
        familyService.joinToFamily(familyId, userId)
    }

    @GetMapping("${PATH_FAMILIES}/{familyId}")
    fun getFamily(@PathVariable familyId: String): Family {
        val family = familyService.getFamily(familyId)
        return family
    }

}