package com.ddcode.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.ddcode.seata.dao"})
public class MyBatisConfig {
}
