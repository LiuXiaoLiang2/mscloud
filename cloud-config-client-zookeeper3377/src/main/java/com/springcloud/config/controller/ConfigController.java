package com.springcloud.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConfigController {

    @Value("${version}")
    private String version;

    @Value("${branch}")
    private String branch;

    @Value("${application.name}")
    private String applicationName;

    @RequestMapping("/getConfig")
    private String getConfig(){
        return applicationName + ", " + branch  + ", " + version;
    }
}
