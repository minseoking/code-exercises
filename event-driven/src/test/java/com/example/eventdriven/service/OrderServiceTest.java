package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.save(new Order());
    }

    @Test
    @DisplayName("주문 취소 성공 테스트")
    void successCancelOrderTest() {
        Order order = orderRepository.findTop1ByOrderByIdDesc();
        try {
            orderService.cancel(order.getId(), false);
        } catch (Exception ignored) {

        }
        Order orderResult = orderRepository.findById(order.getId()).orElse(null);
        assertThat(orderResult).isNull();
    }

    @Test
    @DisplayName("주문 취소 실패 테스트")
    void failCancelOrderTest() {
        Order order = orderRepository.findTop1ByOrderByIdDesc();
        try {
            orderService.cancel(order.getId(), true);
        } catch (Exception ignored) {

        }
        Order orderResult = orderRepository.findById(order.getId()).orElse(null);
        assertThat(orderResult).isNotNull();
    }
}
