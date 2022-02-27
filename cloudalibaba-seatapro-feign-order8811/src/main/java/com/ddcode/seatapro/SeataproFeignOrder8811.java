package com.ddcode.seatapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ddcode.seatapro.dao")
@EnableFeignClients
public class SeataproFeignOrder8811 {
    public static void main(String[] args) {
        SpringApplication.run(SeataproFeignOrder8811.class);
    }
}
