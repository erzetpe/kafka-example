package org.wizzo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wizzo.model.ChatMessage;
import org.wizzo.service.KafkaProducerService;

@RestController
@RequestMapping("/api")
@Slf4j
public class ChatController {

    private static final String VERSION = "v0.0.7";
    private KafkaProducerService kafkaProducerService;

    public ChatController(KafkaProducerService aKafkaProducerService) {
        this.kafkaProducerService = aKafkaProducerService;
    }

    @GetMapping("/version")
    public ResponseEntity<String> getApiVersion() {
        log.debug("Get Api Version: ".concat(VERSION));
        return new ResponseEntity<>(VERSION, HttpStatus.OK);
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody ChatMessage chatMessage) {
        log.info("Sending ChatMessage: ".concat(String.valueOf(chatMessage)));
        return new ResponseEntity<>("Message sent.", HttpStatus.OK);
    }

}
