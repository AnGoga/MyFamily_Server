package com.angogasapps.mediastorageservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class MediaStorageServiceApplication

fun main(args: Array<String>) {
    runApplication<MediaStorageServiceApplication>(*args)
}
