package com.liben.springcloud.seata.service;

import java.math.BigDecimal;

/**
 * @author liben
 * @date 2020/4/28 13:46
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
