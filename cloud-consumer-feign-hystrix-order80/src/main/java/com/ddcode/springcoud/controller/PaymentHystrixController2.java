package com.ddcode.springcoud.controller;

import com.ddcode.springcoud.service.PaymentHystrixService;
import com.ddcode.springcoud.service.PaymentHystrixService2;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Slf4j
public class PaymentHystrixController2 {

    @Resource
    private PaymentHystrixService2 paymentHystrixService2;

    @GetMapping("/consumer2/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        long start = new Date().getTime();
        String result = paymentHystrixService2.paymentInfo_OK(id);
        return result + ", 耗时:" + (new Date().getTime() - start) + " ms";
    }


    @GetMapping("/consumer2/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        long start = new Date().getTime();
        String result = paymentHystrixService2.paymentInfo_TimeOut(id);
        return result + ", 耗时:" + (new Date().getTime() - start) + " ms";
    }

}
