package com.example.eventdriven.service;

import com.example.eventdriven.event.OrderCanceledEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void cancelOrder(Long orderId) {
        applicationEventPublisher.publishEvent(new OrderCanceledEvent(orderId));
    }
}
