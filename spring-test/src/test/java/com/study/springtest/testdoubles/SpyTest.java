package com.study.springtest.testdoubles;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpyTest {

    class OrderRepositorySpy extends OrderRepository {
        private Long saveOrderIdentity;
        private Long findOrderIdentity;

        @Override
        public Long save(Order order) {
            saveOrderIdentity = super.save(order);
            return saveOrderIdentity;
        }

        @Override
        public Order findById(Long orderIdentity) {
            findOrderIdentity = orderIdentity;
            return super.findById(orderIdentity);
        }

        public Long getSaveOrderIdentity() {
            return saveOrderIdentity;
        }

        public Long getFindOrderIdentity() {
            return findOrderIdentity;
        }
    }

    @Test
    @DisplayName("Spy 테스트")
    void spyTest(){
        // given
        OrderRepositorySpy orderRepositorySpy = new OrderRepositorySpy();
        OrderService orderService = new OrderService(orderRepositorySpy);
        Order order = new Order();

        // when
        Long orderIdentity = orderService.createOrder(order);
        Order findOrder = orderService.getOrderById(orderIdentity);

        // then
        assertThat(orderIdentity).isEqualTo(1L);
        assertThat(findOrder).isNotNull();
        assertThat(orderRepositorySpy.getSaveOrderIdentity()).isEqualTo(1L);
        assertThat(orderRepositorySpy.getFindOrderIdentity()).isEqualTo(1L);
    }
}
