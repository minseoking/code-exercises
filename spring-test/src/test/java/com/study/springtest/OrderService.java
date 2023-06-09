package com.study.springtest;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderIdentity) {
        return orderRepository.findById(orderIdentity);
    }
}
