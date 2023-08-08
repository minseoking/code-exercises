package com.example.sagapattern.choreography.order.service;


import com.example.sagapattern.choreography.core.command.CreateOrderCommand;
import com.example.sagapattern.choreography.order.dto.OrderCreateDto;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CommandGateway commandGateway;

    public void createOrder(OrderCreateDto orderCreateDto) {
        commandGateway.send(new CreateOrderCommand(
                UUID.randomUUID().toString(),
                orderCreateDto.getType(),
                orderCreateDto.getPrice(),
                orderCreateDto.getCurrency(),
                "CREATED"
        ));
    }
}
