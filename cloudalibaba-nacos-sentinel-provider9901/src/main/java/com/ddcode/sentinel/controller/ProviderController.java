package com.ddcode.sentinel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/sentinel/nacos/provider/{id}")
    public String getPayment(@PathVariable("id") String id) {
        return "sentinel nacos, id: "+id+" ,serverPort: "+ serverPort;
    }
}
