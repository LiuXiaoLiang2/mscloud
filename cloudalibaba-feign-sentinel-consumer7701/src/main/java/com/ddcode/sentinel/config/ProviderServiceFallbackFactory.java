package com.ddcode.sentinel.config;

import com.ddcode.sentinel.service.ProviderService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProviderServiceFallbackFactory implements FallbackFactory<ProviderService> {
    @Override
    public ProviderService create(Throwable throwable) {
        log.error("调用远程出错, throwable", throwable);
        return new ProviderService(){

            @Override
            public String getPayment(String id) {
                return "调用远程出错 id:" + id;
            }
        };
    }
}
