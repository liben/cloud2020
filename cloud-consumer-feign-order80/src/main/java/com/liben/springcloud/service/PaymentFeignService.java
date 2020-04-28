package com.liben.springcloud.service;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liben
 * @date 2020/4/21 22:43
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout();
}
