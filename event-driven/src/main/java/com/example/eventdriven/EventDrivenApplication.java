package com.example.eventdriven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventDrivenApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventDrivenApplication.class, args);
    }
}
