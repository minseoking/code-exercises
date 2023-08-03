package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.event.OrderCanceledEvent;
import com.example.eventdriven.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void cancel(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        orderRepository.delete(order);

        applicationEventPublisher.publishEvent(new OrderCanceledEvent(orderId));
    }
}
