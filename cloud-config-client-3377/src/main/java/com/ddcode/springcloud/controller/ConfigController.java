package com.ddcode.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${version}")
    private String version;

    @Value("${branch}")
    private String branch;

    @Value("${application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 注意：使用了 @RefreshScope 注解后, controller的方法必须是public
     * @return
     */
    @RequestMapping("/getConfig")
    public String getConfig(){
        return "serverPort: "+serverPort+", applicationName: " + applicationName + ", branch :" + branch  + ", version: " + version;
    }

}
