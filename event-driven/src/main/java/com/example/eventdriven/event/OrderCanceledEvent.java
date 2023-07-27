package com.example.eventdriven.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCanceledEvent {

    private final long timestamp;
    private Long orderId;

    public OrderCanceledEvent(Long orderId) {
        this.timestamp = System.currentTimeMillis();
        this.orderId = orderId;
    }
}
