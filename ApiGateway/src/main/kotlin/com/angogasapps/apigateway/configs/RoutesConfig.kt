package com.angogasapps.apigateway.configs

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.socket.server.RequestUpgradeStrategy
import org.springframework.web.reactive.socket.server.WebSocketService
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy
import org.springframework.web.reactive.socket.server.upgrade.TomcatRequestUpgradeStrategy


//    /websockets/buy_lists
//    /chat/websockets/endpoint

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
            }.route {
                it.path("/family_storage/**")
                    .uri("lb://family-storage-service-client")
            }.route {
                it.path("/chat/websockets/endpoint")
                    .uri("lb:ws://chat-service-client")
            }.route {
                it.path("/websockets/buy_lists")
                    .uri("lb:ws://buy-list-service-client")
            }.build()
    }

//    @Bean
//    fun provideWebSocketService(): WebSocketService {
////        return HandshakeWebSocketService(ReactorNettyRequestUpgradeStrategy())
//        return HandshakeWebSocketService(TomcatRequestUpgradeStrategy())
//    }
//
//    @Bean
//    @Primary
//    fun provideUpgradeStrategy(): RequestUpgradeStrategy {
////        return ReactorNettyRequestUpgradeStrategy()
//        return TomcatRequestUpgradeStrategy()
//    }
}

//https://www.programcreek.com/java-api-examples/?api=org.springframework.web.reactive.socket.server.RequestUpgradeStrategy