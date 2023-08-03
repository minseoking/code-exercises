package com.example.eventdriven.handler;

import com.example.eventdriven.event.OrderCanceledEvent;
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

    @Async
    //@EventListener(OrderCanceledEvent.class)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, classes = OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent orderCanceledEvent) throws Exception {
        refundService.refund(orderCanceledEvent.getOrderId());
    }

}
