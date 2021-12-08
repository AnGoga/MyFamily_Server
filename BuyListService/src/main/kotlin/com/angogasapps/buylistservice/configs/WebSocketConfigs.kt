package com.angogasapps.buylistservice.configs

import com.angogasapps.buylistservice.values.PATH_APP
import com.angogasapps.buylistservice.values.PATH_BUY_LIST_WEBSOCKET_ENDPOINT
import com.angogasapps.buylistservice.values.PATH_TOPIC
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfigs: WebSocketMessageBrokerConfigurer {
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker(PATH_TOPIC)
        registry.setApplicationDestinationPrefixes(PATH_APP)

    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint(PATH_BUY_LIST_WEBSOCKET_ENDPOINT)
        registry.addEndpoint(PATH_BUY_LIST_WEBSOCKET_ENDPOINT).withSockJS()
    }
}
