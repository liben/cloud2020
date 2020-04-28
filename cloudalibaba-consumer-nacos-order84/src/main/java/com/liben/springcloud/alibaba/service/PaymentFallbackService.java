package com.liben.springcloud.alibaba.service;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author liben
 * @date 2020/4/27 16:40
 */

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，------------PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
