package com.example.eventdriven.handler;

import com.example.eventdriven.event.OrderCanceledEvent;
import com.example.eventdriven.service.MessageService;
import com.example.eventdriven.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class OrderCanceledEventHandler {

    private final MessageService messageService;

    @Async
    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent orderCanceledEvent) {
        messageService.sendMessage(orderCanceledEvent);
    }
}
