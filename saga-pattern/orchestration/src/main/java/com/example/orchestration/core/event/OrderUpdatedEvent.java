package com.example.orchestration.core.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderUpdatedEvent {

        private String orderId;
        private String orderStatus;
}
