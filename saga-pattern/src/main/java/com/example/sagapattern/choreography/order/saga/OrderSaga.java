package com.example.sagapattern.choreography.order.saga;

import com.example.sagapattern.choreography.core.command.UpdateOrderStatusCommand;
import com.example.sagapattern.choreography.core.event.InvoiceCreatedEvent;
import com.example.sagapattern.choreography.core.event.OrderUpdatedEvent;
import com.example.sagapattern.choreography.core.command.CreateInvoiceCommand;
import com.example.sagapattern.choreography.core.event.OrderCreatedEvent;
import jakarta.persistence.Transient;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import java.util.UUID;

@Saga
@RequiredArgsConstructor
public class OrderSaga {

    @Transient
    private final CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        String paymentId = UUID.randomUUID().toString();

        SagaLifecycle.associateWith("paymentId", paymentId);

        commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.getOrderId()));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
        commandGateway.send(new UpdateOrderStatusCommand(invoiceCreatedEvent.getOrderId(), "APPROVED"));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void hand(OrderUpdatedEvent orderUpdatedEvent) {
        SagaLifecycle.end();
    }
}
