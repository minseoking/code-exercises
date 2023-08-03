package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    private RefundService refundService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.save(new Order());
    }

    @Test
    @DisplayName("주문 취소 테스트")
    void cancelOrderTest() {
        Order order = orderRepository.findTop1ByOrderByIdDesc();
        try {
            orderService.cancel(order.getId());
        } catch (Exception ignored) {

        }
        Order orderResult = orderRepository.findById(order.getId()).orElse(null);
        assertThat(orderResult).isNull();
    }

}
