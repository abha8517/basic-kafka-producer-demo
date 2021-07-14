package org.learning.springbootkafka.basickafkademo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class KafkaUtils {

    @Autowired
    public KafkaTemplate kafkaTemplate;

    public boolean pushToKafka(String topic, String message) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String,String>> sendResultListenableFuture = kafkaTemplate.send(topic,message);
        log.info("msg::"+sendResultListenableFuture.get().toString());
        return sendResultListenableFuture.isDone();
    }
}
