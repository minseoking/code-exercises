package com.study.springtest.mockito;

import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    @DisplayName("Mock 테스트")
    void mockTest() {
        // given
        when(orderRepository.findById(anyLong())).thenReturn(new Order());

        // when
        Order order = orderService.getOrderById(1000L);

        // then
        verify(orderRepository, times(1)).findById(1000L);
    }
}
