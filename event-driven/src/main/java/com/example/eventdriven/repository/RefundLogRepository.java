package com.example.eventdriven.repository;

import com.example.eventdriven.entity.Order;
import com.example.eventdriven.entity.RefundLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundLogRepository extends JpaRepository<RefundLog, Long> {

    RefundLog findTop1ByOrderByIdDesc();
}
