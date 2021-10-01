package com.example.springkafkap.service;

import com.example.springkafkap.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafKaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Person person)
    {
        logger.info(String.format("Message sent -> %s , %s", person,topic));
        this.kafkaTemplate.send(topic, person);
    }
}
