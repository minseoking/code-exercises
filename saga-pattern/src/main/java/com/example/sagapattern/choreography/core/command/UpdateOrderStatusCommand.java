package com.example.sagapattern.choreography.core.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@AllArgsConstructor
public class UpdateOrderStatusCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String orderStatus;
}
