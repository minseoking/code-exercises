package com.example.sagapattern.orchestration.core.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@AllArgsConstructor
public class CreateInvoiceCommand {

    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
}
