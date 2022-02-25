package com.ddcode.springcoud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements  PaymentHystrixService2{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OpenFeign 整合 Hystrix 兜底方法 paymentInfo_OK , id=" + id ;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "OpenFeign 整合 Hystrix 兜底方法 paymentInfo_TimeOut , id=" + id ;
    }
}
