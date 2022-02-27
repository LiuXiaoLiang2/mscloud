package com.ddcode.seatapro.controller;

import com.ddcode.seatapro.service.OrderClient;
import com.ddcode.seatapro.service.StorageClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    private OrderClient orderClient;
    @Autowired
    private StorageClient storageClient;

    @GetMapping("buy")
    @GlobalTransactional
    public String buy(long userId , long productId){
        orderClient.create(userId , productId);
        storageClient.changeStorage(userId , 1);
        return "ok";
    }
}
