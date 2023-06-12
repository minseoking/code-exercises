package com.study.springtest.testdoubles;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DummyTest {

    class OrderRepositoryDummy extends OrderRepository {
        @Override
        public Order findById(Long orderIdentity) {
            return new Order(); // * Dummy
        }
    }

    @Test
    @DisplayName("Dummy 테스트")
    void dummyTest() {
        // given
        OrderRepositoryDummy orderRepositoryDummy = new OrderRepositoryDummy();
        OrderService orderService = new OrderService(orderRepositoryDummy);

        // when
        Order order = orderService.getOrderById(1000L);

        // then
        assertThat(order).isNotNull();
    }
}
