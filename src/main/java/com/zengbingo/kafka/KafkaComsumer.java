package com.zengbingo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaComsumer{

    @KafkaListener(topics = "kafka-1")
    public void receive(ConsumerRecord<?, ?> consumer) {
        log.info("{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    }
}
