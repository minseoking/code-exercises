package com.study.springtest;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private Map<Long, Order> orderMap = new HashMap<>();

    public Order findById(Long orderIdentity) {
        return orderMap.get(orderIdentity);
    }

    public Long save(Order order) {
        if (orderMap.isEmpty()) {
            order.setId(1L);
        } else {
            orderMap.keySet().stream().max(Long::compareTo).ifPresent(id -> order.setId(id + 1));
        }

        orderMap.put(order.getId(), order);
        return order.getId();
    }
}
