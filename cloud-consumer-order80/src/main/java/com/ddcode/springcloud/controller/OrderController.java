package com.ddcode.springcloud.controller;

import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //单机访问
    //public static String PAYMENT_URL = "http://localhost:8001";
    //通过eureka集群访问
    public static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }
}
