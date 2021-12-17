package com.angogasapps.buylistservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class BuyListServiceApplication

fun main(args: Array<String>) {
    runApplication<BuyListServiceApplication>(*args)
}
