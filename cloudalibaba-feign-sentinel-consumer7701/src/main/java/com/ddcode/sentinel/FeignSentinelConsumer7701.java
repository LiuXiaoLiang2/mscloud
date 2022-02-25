package com.ddcode.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//注册到nacos
@EnableDiscoveryClient
//开启feign支持
@EnableFeignClients
public class FeignSentinelConsumer7701 {
    public static void main(String[] args) {
        SpringApplication.run(FeignSentinelConsumer7701.class);
    }
}
