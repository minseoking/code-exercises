package com.example.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/kafka")
@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic myTopic1;
    private final NewTopic myTopic2;

    @GetMapping("/publish/mytopic1")
    public String publishMessageToMyTopic1() {
        String message = "Hello World from my_topic_1";
        var future = kafkaTemplate.send(myTopic1.name(), message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });

        return "Published successfully";
    }

    @GetMapping("/publish/mytopic2")
    public String publishMessageToMyTopic2() {
        String message = "Hello World from my_topic_2";
        var future = kafkaTemplate.send(myTopic2.name(), message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });

        return "Published successfully";
    }
}
