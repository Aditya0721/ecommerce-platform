package com.server.ecommerce_userservice.service.realtime;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    private final SimpMessagingTemplate template;
    public ChatMessageService(SimpMessagingTemplate template) { this.template = template; }

    public void publishToTopic(String topic, Object payload) {
        template.convertAndSend("/topic/" + topic, payload);
    }

    public void notifyUser(String userId, Object payload) {
        template.convertAndSendToUser(userId, "/queue/notifications", payload);
    }
}
