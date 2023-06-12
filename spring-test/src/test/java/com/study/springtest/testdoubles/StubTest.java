package com.study.springtest.testdoubles;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StubTest {

    class OrderRepositoryStub extends OrderRepository {
        @Override
        public Long save(Order order) {
            return 1000L;
        }
    }

    @Test
    @DisplayName("Stub 테스트")
    void stubTest() {
        // given
        OrderRepositoryStub orderRepositoryStub = new OrderRepositoryStub();
        OrderService orderService = new OrderService(orderRepositoryStub);
        Order order = new Order();

        // when
        Long orderIdentity = orderService.createOrder(order);

        // then
        assertThat(orderIdentity).isEqualTo(1000L);
    }
}
