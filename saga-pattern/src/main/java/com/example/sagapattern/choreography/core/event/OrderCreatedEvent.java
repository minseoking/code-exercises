package com.example.sagapattern.choreography.core.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderCreatedEvent {

    private String orderId;
    private String type;
    private String currency;
    private String status;
    private BigDecimal price;
}
