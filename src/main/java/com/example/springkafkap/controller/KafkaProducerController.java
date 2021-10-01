package com.example.springkafkap.controller;

import com.example.springkafkap.domain.Person;
import com.example.springkafkap.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

    private final KafKaProducerService producerService;

    @Autowired
    public KafkaProducerController(KafKaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/personpublish")
    public void sendMessageToKafkaTopic(@RequestBody Person person, @RequestParam String topic) {
        producerService.sendMessage(topic, person);
    }
}
