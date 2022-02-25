package com.ddcode.sentinel.service.impl;

import com.ddcode.sentinel.service.ProviderService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String getPayment(String id) {
        return "id: " + id + " 进入兜底方法:调用远程服务异常";
    }
}
