package com.ddcode.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ddcode.springcloud.entities.CommonResult;
import com.ddcode.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/sentinelByResourceUrl")
    @SentinelResource(value = "sentinelByResource", blockHandler = "sentinelByResourceBlockHandler")
    public CommonResult sentinelByResource(){
        return new CommonResult(200, "sentinelByResourceUrl success");
    }

    public CommonResult sentinelByResourceBlockHandler(BlockException blockException){
        return new CommonResult(500, "进入自定义的兜底方法:" + blockException.getMessage());
    }


    @GetMapping("/sentinelByUrl")
    public CommonResult sentinelByResourceUrl(){
        return new CommonResult(200, "sentinelByUrl success");
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler" ,
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "customerBlockHandler success");
    }
}
