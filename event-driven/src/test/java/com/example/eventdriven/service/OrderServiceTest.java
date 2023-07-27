package com.example.eventdriven.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class OrderServiceTest {

    @MockBean
    private RefundService refundService;

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("주문 취소 테스트")
    void cancelOrderTest() {
        orderService.cancelOrder(1L);

        verify(refundService).refund(anyLong());
    }

}
