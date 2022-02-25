package com.ddcode.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    public static String BASE_URL = "nacos-sentinel-provider";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/sentinel/nacos/consumer/{id}")
    @SentinelResource(fallback = "sentinelFallback")
    public String fallback(@PathVariable Long id) {
        String response = restTemplate.getForObject("http://"+ BASE_URL + "/sentinel/nacos/provider/" + id, String.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }

        return response;
    }

    public String sentinelFallback(@PathVariable Long id, Throwable throwable) {
        return "进入运行异常兜底方法 sentinelFallback , id:" + id + ", 异常信息 :" + throwable.getMessage();
    }


    @GetMapping(value = "/sentinel/nacos/consumer2/{id}")
    @SentinelResource(value = "sentinelFallback1", blockHandler = "sentinelBlockHandler")
    public String fallback2(@PathVariable Long id) {
        String response = restTemplate.getForObject("http://"+ BASE_URL + "/sentinel/nacos/provider/" + id, String.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }
        return response;
    }

    public String sentinelBlockHandler(@PathVariable Long id, BlockException blockException) {
        return "进入触发sentinel规则的兜底方法 sentinelBlockHandler , id:" + id + ", 异常信息 :" + blockException.getMessage();
    }


    @GetMapping(value = "/sentinel/nacos/consumer3/{id}")
    @SentinelResource(value = "sentinelFallback2", blockHandler = "sentinelBlockHandler2", fallback = "sentinelFallback2")
    public String fallback3(@PathVariable Long id) {
        String response = restTemplate.getForObject("http://"+ BASE_URL + "/sentinel/nacos/provider/" + id, String.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }
        return response;
    }

    public String sentinelBlockHandler2(@PathVariable Long id, BlockException blockException) {
        return "进入触发sentinel规则的兜底方法 sentinelBlockHandler2 , id:" + id + ", 异常信息 :" + blockException.getMessage();
    }

    public String sentinelFallback2(@PathVariable Long id, Throwable throwable) {
        return "进入运行异常兜底方法 sentinelFallback , id:" + id + ", 异常信息 :" + throwable.getMessage();
    }


    @GetMapping(value = "/sentinel/nacos/consumer4/{id}")
    @SentinelResource(value = "sentinelFallback3", blockHandler = "sentinelBlockHandler3", fallback = "sentinelFallback3",
            exceptionsToIgnore = IllegalArgumentException.class)
    public String fallback4(@PathVariable Long id) {
        String response = restTemplate.getForObject("http://"+ BASE_URL + "/sentinel/nacos/provider/" + id, String.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }
        return response;
    }

    public String sentinelBlockHandler3(@PathVariable Long id, BlockException blockException) {
        return "进入触发sentinel规则的兜底方法 sentinelBlockHandler2 , id:" + id + ", 异常信息 :" + blockException.getMessage();
    }

    public String sentinelFallback3(@PathVariable Long id, Throwable throwable) {
        return "进入运行异常兜底方法 sentinelFallback , id:" + id + ", 异常信息 :" + throwable.getMessage();
    }

}
