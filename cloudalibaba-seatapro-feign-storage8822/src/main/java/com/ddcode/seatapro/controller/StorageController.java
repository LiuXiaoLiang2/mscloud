package com.ddcode.seatapro.controller;

import com.ddcode.seatapro.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("storage/change")
    public Boolean changeStorage(long productId , int used)  {
        return storageService.updateUseNum(productId , used);
    }

}
