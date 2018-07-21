package org.wizzo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.wizzo.model.ChatMessage;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(ChatMessage chatMessage) {
        kafkaTemplate.send("chat", chatMessage.toString());
    }

}
