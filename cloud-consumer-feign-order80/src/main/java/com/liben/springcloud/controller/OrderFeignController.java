package com.liben.springcloud.controller;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;
import com.liben.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/21 22:48
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
