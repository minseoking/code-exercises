package com.study.springtest.testdoubles;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockTest {
    class OrderRepositoryMock extends OrderRepository {
        @Override
        public Order findById(Long orderIdentity) {
            return new Order();
        }
    }

    @Test
    @DisplayName("Mock 테스트")
    void mockTest() {
        // given
        OrderRepositoryMock orderRepositoryMock = new OrderRepositoryMock();
        OrderService orderService = new OrderService(orderRepositoryMock);

        // when
        Order order = orderService.getOrderById(1000L);

        // then
        assertThat(order).isNotNull();
    }
}
