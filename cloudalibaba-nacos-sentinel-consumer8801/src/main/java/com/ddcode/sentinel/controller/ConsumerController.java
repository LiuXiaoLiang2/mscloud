package com.ddcode.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    public static String BASE_URL = "nacos-sentinel-provider";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/sentinel/nacos/consumer/{id}")
    public String fallback(@PathVariable Long id) {
        String response = restTemplate.getForObject(BASE_URL + "/sentinel/nacos/provider/" + id, String.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }

        return response;
    }
}
