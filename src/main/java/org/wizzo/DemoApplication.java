package org.wizzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.wizzo.model.ChatMessage;
import org.wizzo.service.KafkaProducerService;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    private List<String> testData = Arrays.asList("My dog has no nose.",
            "How does he smell?",
            "Terrible.");

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (String... args) -> testData.stream().forEach(
                message -> kafkaProducerService
                        .sendMessage(
                                new ChatMessage("Pawel", message)
                        ));
    }

}
