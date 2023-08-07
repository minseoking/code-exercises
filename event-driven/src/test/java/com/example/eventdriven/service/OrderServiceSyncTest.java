package com.example.eventdriven.service;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.entity.RefundLog;
import com.example.eventdriven.repository.OrderRepository;
import com.example.eventdriven.repository.RefundLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;

@SpringBootTest
public class OrderServiceSyncTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RefundLogRepository refundLogRepository;

    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @BeforeEach
    void setUp() {
        orderRepository.save(new Order());
        refundLogRepository.deleteAll();
    }

    @Test
    @DisplayName("주문 취소 성공 테스트")
    void successCancelOrderTest() {
        // given
        Order order = orderRepository.findTop1ByOrderByIdDesc();

        // when
        orderService.cancel(order.getId(), false, false);


        // then
        Order orderResult = orderRepository.findById(order.getId()).orElse(null);
        RefundLog refundLog = refundLogRepository.findTop1ByOrderByIdDesc();
        assertThat(orderResult).isNull();
        assertThat(refundLog).isNotNull();
    }

    @Test
    @DisplayName("주문 취소 실패 테스트")
    void failCancelOrderTest() {
        // given
        Order order = orderRepository.findTop1ByOrderByIdDesc();

        // when
        assertThatRuntimeException().isThrownBy(() -> orderService.cancel(order.getId(), false, true));

        // then
        Order orderResult = orderRepository.findById(order.getId()).orElse(null);
        RefundLog refundLog = refundLogRepository.findTop1ByOrderByIdDesc();
        assertThat(orderResult).isNotNull();
        assertThat(refundLog).isNull();
    }
}
