package com.example.sagapattern.choreography.core.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String type;
    private BigDecimal price;
    private String currency;
    private String status;

}
