package com.example.sagapattern.order.controller;

import com.example.sagapattern.orchestration.order.dto.OrderCreateDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalServerPort
    private Integer port;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void createOrder() throws JsonProcessingException {

        OrderCreateDto dto = new OrderCreateDto(
                "",
                "test",
                new BigDecimal(10000)
        );

        String body = objectMapper.writeValueAsString(dto);


        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/orders")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.OK.value());
    }
}