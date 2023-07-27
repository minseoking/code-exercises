package com.example.eventdriven.handler;

import com.example.eventdriven.event.OrderCanceledEvent;
import com.example.eventdriven.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCanceledEventHandler {

    private final RefundService refundService;

    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent orderCanceledEvent) {
        refundService.refund(orderCanceledEvent.getOrderId());
    }

}
