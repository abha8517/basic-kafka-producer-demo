package org.learning.springbootkafka.basickafkademo.controller;

import org.learning.springbootkafka.basickafkademo.util.KafkaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ProducerController {

    @Autowired
    private KafkaUtils kafkaUtils;

    @PostMapping("/produce")
    public String kafkaProducer(@RequestBody String message ) throws ExecutionException, InterruptedException {
        if(kafkaUtils.pushToKafka("testTopic",message))
        return "Message pushed to Kafka";
        else return "Something went wrong";
    }

}
