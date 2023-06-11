package com.study.springtest;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/api/{orderId}/order")
    @ResponseStatus(HttpStatus.OK)
    public Order getMenus(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
}
