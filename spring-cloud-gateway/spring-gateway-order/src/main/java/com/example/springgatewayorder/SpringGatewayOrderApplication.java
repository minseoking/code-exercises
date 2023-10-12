package com.example.springgatewayorder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class SpringGatewayOrderApplication {

    private final Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SpringGatewayOrderApplication.class, args);
    }

    @GetMapping("/order/info")
    public String info(@Value("${server.port}") String port) {
        String localPort = env.getProperty("local.server.port");
        return "order service port : " + localPort;
    }

}
