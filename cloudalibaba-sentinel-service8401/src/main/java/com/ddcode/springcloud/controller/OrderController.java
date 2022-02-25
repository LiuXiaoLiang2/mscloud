package com.ddcode.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        //Thread.sleep(1000);
        log.info("-----testA");
        int i = 10 / 0;
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }


    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        Thread.sleep(1000);
        log.info("-----testC");
        return "------testC";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "hotkey", blockHandler = "testHotKeyBlockHandler")
    public String testHotKey(@RequestParam(required = false) String a1,
                             @RequestParam(required = false) String a2) throws InterruptedException {
        int i = 10/ 0;
        log.info("-----testHotKey");
        return "------testHotKey";
    }

    public String testHotKeyBlockHandler(@RequestParam(required = false) String a1,
                                         @RequestParam(required = false) String a2, BlockException blockException){
        return "进入兜底方法 testHotKeyBlockHandler";
    }
}
