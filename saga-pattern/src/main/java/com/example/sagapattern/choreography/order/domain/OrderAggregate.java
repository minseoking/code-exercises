package com.example.sagapattern.choreography.order.domain;


import com.example.sagapattern.choreography.core.command.CreateOrderCommand;
import com.example.sagapattern.choreography.core.command.UpdateOrderStatusCommand;
import com.example.sagapattern.choreography.core.event.OrderUpdatedEvent;
import com.example.sagapattern.choreography.core.event.OrderCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class OrderAggregate {
    private String orderId;
    private String type;
    private String currency;
    private String status;
    private BigDecimal price;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        orderId = command.getOrderId();
        AggregateLifecycle.apply(new OrderCreatedEvent(
                orderId, command.getType(),
                command.getCurrency(),
                command.getStatus(),
                command.getPrice()
        ));
    }

    @EventSourcingHandler
    protected void on(OrderCreatedEvent event) {
        orderId = event.getOrderId();
        type = event.getType();
        currency = event.getCurrency();
        status = event.getStatus();
        price = event.getPrice();
    }

    @CommandHandler
    protected void on(UpdateOrderStatusCommand event) {
        AggregateLifecycle.apply(new OrderUpdatedEvent(
                event.getOrderId(),
                event.getOrderStatus()
        ));
    }

    @EventSourcingHandler
    protected void on(OrderUpdatedEvent event) {
        orderId = event.getOrderId();
        status = event.getOrderStatus();
    }
}
