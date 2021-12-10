package com.angogasapps.buylistservice.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessagingTemplate

@Configuration
class TopicsConfigs {
//    @Bean
//    fun brokerMessagingTemplate(): SimpMessagingTemplate {
//        val template = SimpMessagingTemplate(brokerChannel());
//        val prefix = getBrokerRegistry().getUserDestinationPrefix();
//        if (prefix != null) {
//            template.userDestinationPrefix = prefix;
//        }
//    }
}