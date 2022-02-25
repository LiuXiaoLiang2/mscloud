package com.ddcode.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosSentinelProvider9901 {
    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelProvider9901.class);
    }
}
