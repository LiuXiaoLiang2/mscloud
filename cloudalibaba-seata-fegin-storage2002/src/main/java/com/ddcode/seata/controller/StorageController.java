package com.ddcode.seata.controller;

import com.ddcode.seata.domain.CommonResult;
import com.ddcode.seata.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
