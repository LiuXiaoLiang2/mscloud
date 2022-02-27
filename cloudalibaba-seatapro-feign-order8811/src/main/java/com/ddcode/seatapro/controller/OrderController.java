package com.ddcode.seatapro.controller;

import com.ddcode.seatapro.domain.Order;
import com.ddcode.seatapro.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order/create")
    public Boolean create(long userId , long productId){
        Order order = new Order();
        order.setCount(1)
                .setMoney(BigDecimal.valueOf(88))
                .setProductId(productId)
                .setUserId(userId)
                .setStatus(0);
        return orderService.create(order);
    }
}
