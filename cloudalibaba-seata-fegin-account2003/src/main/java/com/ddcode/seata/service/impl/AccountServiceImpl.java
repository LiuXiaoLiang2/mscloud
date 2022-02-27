package com.ddcode.seata.service.impl;

import com.ddcode.seata.dao.AccountDao;
import com.ddcode.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //抛异常，全局事务回滚
        int i = 10 / 0;
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
