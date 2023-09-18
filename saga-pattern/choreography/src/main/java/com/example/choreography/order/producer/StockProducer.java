package com.example.choreography.order.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockProducer {
    private final KafkaTemplate<String,Long> kafkaTemplate;
    public void order(Long id) {
        kafkaTemplate.send("order-create", id);
    }
}
