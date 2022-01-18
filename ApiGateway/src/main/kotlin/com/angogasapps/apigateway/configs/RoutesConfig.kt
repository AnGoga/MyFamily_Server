package com.angogasapps.apigateway.configs

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Function


@Configuration
class RoutesConfig {
    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route {
                it.path("/buy_lists/**")
                .uri("lb://buy-list-service-client")
            }.route {
                it.path("/users-and-families/**")
                .uri("lb://users-and-families-service-client")
            }.route {
                it.path("/media_storage/**")
                    .uri("lb://media-storage-service-client")
            }.route {
                it.path("/chat/**")
                    .uri("lb://chat-service-client")
            }.build()
    }
}