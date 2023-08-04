package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.entity.RefundLog;
import com.example.eventdriven.repository.RefundLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefundService {

    private final RefundLogRepository refundLogRepository;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void refund(Long orderId, boolean isThrowException) {
        refundLogRepository.save(new RefundLog(orderId));

        if (isThrowException) throw new RuntimeException();

        log.info("{} 주문에 대한 결제 환불이 완료되었습니다.", orderId);
    }
}
