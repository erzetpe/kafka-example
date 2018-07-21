package org.wizzo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class KafkaClientService {

    private List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "chat")
    public void listen(@Payload String message) {
        log.info("Added message: " + message);
        messages.add(message);
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
