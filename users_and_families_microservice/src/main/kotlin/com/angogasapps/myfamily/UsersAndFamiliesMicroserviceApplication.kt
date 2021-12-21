package com.angogasapps.myfamily

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class UsersAndFamiliesMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<UsersAndFamiliesMicroserviceApplication>(*args)
}
