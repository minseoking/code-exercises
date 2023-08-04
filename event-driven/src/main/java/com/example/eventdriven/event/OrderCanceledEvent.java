package com.example.eventdriven.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCanceledEvent {

    private final long timestamp;
    private Long orderId;
    private boolean isThrowException;

    public OrderCanceledEvent(Long orderId, boolean isThrowException) {
        this.timestamp = System.currentTimeMillis();
        this.orderId = orderId;
        this.isThrowException = isThrowException;
    }
}
