package com.ddcode.seatapro.service.impl;

import com.ddcode.seatapro.dao.StorageMapper;
import com.ddcode.seatapro.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    @Transactional
    public boolean updateUseNum(long productId , long used) {
        int a = 100/0;
        int index = storageMapper.updateUsed(productId, used);
        return index > 0;
    }
}
