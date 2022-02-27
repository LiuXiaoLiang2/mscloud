package com.ddcode.seatapro.dao;

import com.ddcode.seatapro.domain.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderMapper extends Mapper<Order> {
}
