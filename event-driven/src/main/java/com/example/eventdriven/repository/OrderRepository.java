package com.example.eventdriven.repository;

import com.example.eventdriven.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findTop1ByOrderByIdDesc();
}
