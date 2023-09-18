package com.example.choreography.order.service;


import com.example.choreography.order.producer.StockProducer;
import com.example.choreography.order.domain.Order;
import com.example.choreography.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final StockProducer stockProducer;

    public void order(String productId) {
        Order order = new Order(productId);
        orderRepository.save(order);
        stockProducer.order(order.getId());
    }

    public void cancel(Long orderId) {
        orderRepository.deleteById(orderId);
        log.info("{} 주문이 취소되었습니다.", orderId);
    }
}
