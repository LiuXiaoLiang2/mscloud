package com.ddcode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//开启zookeeper服务注册功能
@EnableDiscoveryClient
public class ZkOpenFeignPaymentMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOpenFeignPaymentMain8005.class);
    }
}
