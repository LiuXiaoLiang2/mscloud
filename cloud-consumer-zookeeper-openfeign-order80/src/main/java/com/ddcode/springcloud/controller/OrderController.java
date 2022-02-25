package com.ddcode.springcloud.controller;

import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.entities.Payment;
import com.ddcode.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/consumer/payment/zookeeper/openFeign/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return orderService.create(payment);
    }

    @GetMapping("/consumer/payment/zookeeper/openFeign/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return orderService.getPaymentById(id);
    }
}
