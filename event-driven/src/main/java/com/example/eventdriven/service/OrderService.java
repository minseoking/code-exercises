package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.event.OrderCanceledAsyncEvent;
import com.example.eventdriven.event.OrderCanceledEvent;
import com.example.eventdriven.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void cancel(Long orderId, boolean isAsync , boolean isThrowException) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        orderRepository.delete(order);
        if (isAsync) {
            applicationEventPublisher.publishEvent(new OrderCanceledAsyncEvent(orderId, isThrowException));
        } else {
            applicationEventPublisher.publishEvent(new OrderCanceledEvent(orderId, isThrowException));
        }

    }
}
