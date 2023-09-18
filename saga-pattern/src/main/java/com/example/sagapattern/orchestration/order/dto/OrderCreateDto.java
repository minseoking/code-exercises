package com.example.sagapattern.orchestration.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderCreateDto {
    private String type;
    private String currency;
    private BigDecimal price;
}
