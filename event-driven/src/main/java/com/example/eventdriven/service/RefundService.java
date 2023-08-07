package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.entity.RefundLog;
import com.example.eventdriven.event.OrderCanceledAsyncEvent;
import com.example.eventdriven.event.OrderCanceledEvent;
import com.example.eventdriven.event.OrderCanceledMessageEvent;
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


    public void refund(OrderCanceledEvent event) {
        refundLogRepository.save(new RefundLog(event.getOrderId()));

        if (event.isThrowException()) throw new RuntimeException();

        log.info("{} 주문에 대한 결제 환불이 완료되었습니다.", event.getOrderId());
    }

    public void refundAsync(OrderCanceledAsyncEvent event) {
        refundLogRepository.save(new RefundLog(event.getOrderId()));

        if (event.isThrowException()) throw new RuntimeException();

        log.info("{} 주문에 대한 결제 환불이 완료되었습니다.", event.getOrderId());
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void refundMessage(OrderCanceledMessageEvent event) {
        refundLogRepository.save(new RefundLog(event.getOrderId()));

        if (event.isThrowException()) throw new RuntimeException();

        log.info("{} 주문에 대한 결제 환불이 완료되었습니다.", event.getOrderId());
    }
}
