package com.ddcode.springcloud.controller;

import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.entities.Payment;
import com.ddcode.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class paymentController {

    @Resource
    private OrderService orderService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/zookeeper/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        CommonResult commonResult = orderService.create(payment);
        commonResult.setMessage(commonResult.getMessage() + ",serverPort:" + serverPort);
        return commonResult;
    }

    @GetMapping(value = "/zookeeper/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = orderService.getPaymentById(id);
        commonResult.setMessage(commonResult.getMessage() + ",serverPort:" + serverPort);
        return commonResult;
    }
}
