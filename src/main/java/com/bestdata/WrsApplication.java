package com.bestdata;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication(scanBasePackages = "com.bestdata")
public class WrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrsApplication.class, args);
    }
}
