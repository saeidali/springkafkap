package com.example.springkafkap.service;

import com.example.springkafkap.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {
    private final Logger logger =
            LoggerFactory.getLogger(KafKaConsumerService.class);

    @KafkaListener(topics = "testTopic", groupId = "group-id")
    public void consume(Person person) {
        logger.info(String.format("Message recieved topic1 -> %s", person));
    }

    @KafkaListener(topics = "testTopic2", groupId = "group-id")
    public void consume2(Person person) {
        logger.info(String.format("Message recieved topic2 -> %s", person));
    }
}
