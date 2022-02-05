package com.angogasapps.familystorageservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class FamilyStorageServiceApplication

fun main(args: Array<String>) {
    runApplication<FamilyStorageServiceApplication>(*args)
}
