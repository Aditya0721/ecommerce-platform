package com.server.ecommerce_userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")               // WebSocket handshake endpoint
                .setAllowedOriginPatterns("*")    // tighten for prod
                .withSockJS();                    // enable SockJS fallback (optional)
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // client sends to /app/...
        registry.setApplicationDestinationPrefixes("/app");
        // server broadcasts to /topic/... or p2p to /queue/...
        registry.enableSimpleBroker("/topic", "/queue");
    }
}
