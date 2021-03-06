package com.ddcode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumer8803.class);
    }
}
