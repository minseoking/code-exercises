package com.example.choreography.order.consumer;

import com.example.choreography.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RollbackConsumer {
    private final OrderService orderService;

    @KafkaListener(topics = "order-rollback", groupId = "group-01")
    public void rollbackOrder(Long orderId) {
        log.info("주문이 취소되었습니다. 주문번호: {}", orderId);
        orderService.cancel(orderId);
    }
}
