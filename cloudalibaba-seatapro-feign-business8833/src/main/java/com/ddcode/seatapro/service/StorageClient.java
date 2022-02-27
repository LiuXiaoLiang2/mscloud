package com.ddcode.seatapro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "storage-service")
@Component
public interface StorageClient {

    @GetMapping("storage/change")
    Boolean changeStorage(@RequestParam("productId") long productId , @RequestParam("used")  int used);

}