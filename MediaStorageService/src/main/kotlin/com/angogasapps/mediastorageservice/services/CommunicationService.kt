package com.angogasapps.mediastorageservice.services

import com.angogasapps.mediastorageservice.models.MediaFileInfo
import com.angogasapps.mediastorageservice.utils.toStorageType
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CommunicationService {
    private val restTemplate = RestTemplate()
    @Autowired
    private lateinit var eurekaClient: EurekaClient
    @Autowired
    private lateinit var objectMapper: ObjectMapper


    fun requestToFamilyStorage(info: MediaFileInfo, requestStr: String? = null, path: String): ResponseEntity<String> {
        val instanceInfo = eurekaClient
            .getApplication("family-storage-service-client")
            .instances
            .also { println(it) }
            .random()

        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
            accept = listOf(MediaType.APPLICATION_JSON)
        }
        val request: HttpEntity<String> = HttpEntity<String>(objectMapper.writeValueAsString(info), headers)
        val response = restTemplate.postForEntity(
            "http://${instanceInfo.ipAddr}:${instanceInfo.port}/${path}",
            request,
            String::class.java
        )
        return response
    }
}
//"http://${instanceInfo.ipAddr}:${instanceInfo.port}/family_storage/data/families/${info.familyId}/data/${info.type.toStorageType()}/create/file",