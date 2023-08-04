package com.example.eventdriven.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

@Entity
@Getter
@Table(name = "refund_logs")
@NoArgsConstructor
public class RefundLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    public RefundLog(Long orderId) {
        this.orderId = orderId;
    }
}
