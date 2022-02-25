package com.ddcode.sentinel.service;

import com.ddcode.sentinel.config.ProviderServiceFallbackFactory;
import com.ddcode.sentinel.service.impl.ProviderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "nacos-sentinel-provider", fallback = ProviderServiceImpl.class)
@FeignClient(value = "nacos-sentinel-provider", fallbackFactory = ProviderServiceFallbackFactory.class)
public interface ProviderService {

    @GetMapping(value = "/sentinel/nacos/provider/{id}")
    public String getPayment(@PathVariable("id") String id);
}
