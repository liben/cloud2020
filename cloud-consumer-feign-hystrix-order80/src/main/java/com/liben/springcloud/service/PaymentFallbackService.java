package com.liben.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author liben
 * @date 2020/4/24 14:40
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----来自于paymentHystrixService这个类 fall back paymentInfo_OK,O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----来自于paymentHystrixService这个类 fall back paymentInfo_TimeOut,O(∩_∩)O哈哈~";
    }
}
