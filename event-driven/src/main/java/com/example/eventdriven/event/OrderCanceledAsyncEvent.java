package com.example.eventdriven.event;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCanceledAsyncEvent {

    private long timestamp;
    private Long orderId;
    private boolean isThrowException;

    public OrderCanceledAsyncEvent(Long orderId, boolean isThrowException) {
        this.timestamp = System.currentTimeMillis();
        this.orderId = orderId;
        this.isThrowException = isThrowException;
    }
}
