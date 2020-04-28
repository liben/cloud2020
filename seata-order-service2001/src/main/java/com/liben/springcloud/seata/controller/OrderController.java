package com.liben.springcloud.seata.controller;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.seata.domain.Order;
import com.liben.springcloud.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/28 12:35
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建完成");
    }

}
