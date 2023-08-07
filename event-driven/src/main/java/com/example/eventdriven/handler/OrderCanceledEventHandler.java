package com.example.eventdriven.handler;

import com.example.eventdriven.event.OrderCanceledAsyncEvent;
import com.example.eventdriven.event.OrderCanceledEvent;
import com.example.eventdriven.event.OrderCanceledMessageEvent;
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

    private final RefundService refundService;
    private final MessageService messageService;

    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent orderCanceledEvent) {
        refundService.refund(orderCanceledEvent);
    }

    @Async
    @TransactionalEventListener(classes = OrderCanceledAsyncEvent.class, phase = TransactionPhase.AFTER_COMMIT)
//    @EventListener(OrderCanceledAsyncEvent.class)
    public void handleAsync(OrderCanceledAsyncEvent orderCanceledEvent) {
        refundService.refundAsync(orderCanceledEvent);
    }

    @Async
    @TransactionalEventListener(classes = OrderCanceledMessageEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void handleMessage(OrderCanceledMessageEvent orderCanceledEvent) {
        messageService.sendMessage(orderCanceledEvent);
    }
}
