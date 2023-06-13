package com.study.springtest.mockito;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MockBeanTest {

    @MockBean
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("MockBean 테스트")
    void mockBeanTest() {
        // given
        when(orderRepository.findById(anyLong())).thenReturn(new Order());

        // when
        Order order = orderService.getOrderById(1000L);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(1000L));
    }
}
