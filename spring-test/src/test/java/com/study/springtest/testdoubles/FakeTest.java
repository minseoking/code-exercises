package com.study.springtest.testdoubles;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeTest {

    class OrderRepositoryFake extends OrderRepository {
        private final List<Order> orders = List.of(new Order(), new Order()); // * Fake

        @Override
        public Order findById(Long orderIdentity) {
            return orders.stream()
                    .filter(x -> orderIdentity.equals(x.getId()))
                    .findAny().orElse(null);
        }
    }

    @Test
    @DisplayName("Fake 테스트")
    void fakeTest() {
        // given
        OrderRepositoryFake orderRepositoryFake = new OrderRepositoryFake();
        OrderService orderService = new OrderService(orderRepositoryFake);

        // when
        Order order = orderService.getOrderById(1000L);

        // then
        assertThat(order).isNotNull();
    }
}
