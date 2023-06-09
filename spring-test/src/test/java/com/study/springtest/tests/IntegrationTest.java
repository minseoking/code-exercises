package com.study.springtest.tests;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IntegrationTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("주문 테스트")
    void orderTest() {
        // given
        Order order = new Order();

        // when
        Long orderIdentity = orderService.createOrder(order);

        // then
        Long saveId = orderRepository.findById(orderIdentity).getId();
        assertThat(saveId).isEqualTo(orderIdentity);
    }
}
