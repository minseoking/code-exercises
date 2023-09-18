package com.example.sagapattern.orchestration.core.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceCreatedEvent {

        private String paymentId;
        private String orderId;
}
