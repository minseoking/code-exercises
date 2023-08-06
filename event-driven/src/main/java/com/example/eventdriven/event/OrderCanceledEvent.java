package com.example.eventdriven.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCanceledEvent {

    private long timestamp;
    private Long orderId;
    private boolean isThrowException;

    public OrderCanceledEvent(Long orderId, boolean isThrowException) {
        this.timestamp = System.currentTimeMillis();
        this.orderId = orderId;
        this.isThrowException = isThrowException;
    }
}
