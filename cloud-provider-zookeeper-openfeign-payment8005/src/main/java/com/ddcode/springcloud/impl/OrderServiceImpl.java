package com.ddcode.springcloud.impl;

import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.entities.Payment;
import com.ddcode.springcloud.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(200, "getPaymentById, id:" + id);
    }

    @Override
    public CommonResult create(Payment payment) {
        return new CommonResult(200, "create, id:" + payment);
    }
}
