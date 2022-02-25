package com.ddcode.sentinel.controller;

import com.ddcode.sentinel.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private ProviderService providerService;

    @GetMapping(value = "/sentinel/feign/consumer/{id}")
    public String fallback(@PathVariable String id) {
        return providerService.getPayment(id);
    }
}
