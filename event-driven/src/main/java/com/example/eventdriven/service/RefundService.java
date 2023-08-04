package com.example.eventdriven.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RefundService {
    public void refund(Long orderId) {
        log.info("{} 주문에 대한 결제 환불이 완료되었습니다.", orderId);
        throw new RuntimeException();
    }
}
