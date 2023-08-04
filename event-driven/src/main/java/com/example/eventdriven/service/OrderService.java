package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final RefundService refundService;

    @Transactional
    public void cancel(Long orderId, boolean isThrowException) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        orderRepository.delete(order);

        refundService.refund(orderId, isThrowException);

//        applicationEventPublisher.publishEvent(new OrderCanceledEvent(orderId));
    }
}
