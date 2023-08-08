package com.example.sagapattern.choreography.pay.domain;

import com.example.sagapattern.choreography.core.command.CreateInvoiceCommand;
import com.example.sagapattern.choreography.core.event.InvoiceCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class InvoiceAggregate {

    @AggregateIdentifier
    private String paymentId;
    private String orderId;
    private String invoiceStatus;

    @CommandHandler
    public InvoiceAggregate(CreateInvoiceCommand command) {
        paymentId = command.getPaymentId();
        AggregateLifecycle.apply(new InvoiceCreatedEvent(paymentId, command.getOrderId()));
    }

    @EventSourcingHandler
    public void on(InvoiceCreatedEvent event) {
        orderId = event.getOrderId();
        paymentId = "PAID";
    }
}
