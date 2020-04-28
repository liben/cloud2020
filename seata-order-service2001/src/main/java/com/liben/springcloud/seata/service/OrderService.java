package com.liben.springcloud.seata.service;

import com.liben.springcloud.seata.domain.Order;

/**
 * @author liben
 * @date 2020/4/28 12:33
 */
public interface OrderService {
    void create(Order order);
}
