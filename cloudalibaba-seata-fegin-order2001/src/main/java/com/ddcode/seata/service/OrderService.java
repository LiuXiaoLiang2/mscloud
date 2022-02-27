package com.ddcode.seata.service;

import com.ddcode.seata.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
