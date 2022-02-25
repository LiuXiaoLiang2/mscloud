package com.ddcode.springcloud.controller;

import com.ddcode.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.sendMessage();
    }
}
