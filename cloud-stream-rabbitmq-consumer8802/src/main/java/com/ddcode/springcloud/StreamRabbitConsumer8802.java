package com.ddcode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumer8802.class);
    }
}
