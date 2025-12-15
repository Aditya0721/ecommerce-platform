package com.server.ecommerce_userservice.controller.realtime;


import com.server.ecommerce_userservice.dto.realtime.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Client publishes to /app/chat.send
    // Everyone listening to /topic/messages will receive the return value
    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public ChatMessage broadcast(@Payload ChatMessage msg) {
        // Here you could enrich/persist, validate, etc.
        return msg;
    }
}
