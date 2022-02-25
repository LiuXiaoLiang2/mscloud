package com.ddcode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitProvider8801.class);
    }
}
