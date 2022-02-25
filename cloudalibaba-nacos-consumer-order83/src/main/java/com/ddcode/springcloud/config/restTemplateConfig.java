package com.ddcode.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class restTemplateConfig {

    @Bean
    @LoadBalanced//使用应用名称进行调用, 必须加该注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
