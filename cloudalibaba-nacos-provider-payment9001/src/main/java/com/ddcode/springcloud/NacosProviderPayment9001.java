package com.ddcode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderPayment9001 {
    public static void main(String[] args) {
        System.setProperty("nacos.standalone", "false");
        SpringApplication.run(NacosProviderPayment9001.class);
    }
}
