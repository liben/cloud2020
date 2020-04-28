package com.liben.springcloud.seata.service.impl;

import com.liben.springcloud.seata.dao.StorageDao;
import com.liben.springcloud.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/28 13:38
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----------->storageService开始扣减库存");
        storageDao.decrease(productId, count);
        log.info("----------->storageService结束扣减库存");
    }

}
