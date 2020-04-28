package com.liben.springcloud.controller;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/16 16:56
 */
@RestController
@Slf4j
public class OrderController {

    //public static final  String payment_url = "http://localhost:8001";
    public static final  String payment_url = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(payment_url+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(payment_url+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("consumer/payment/zipkin")
    public String paymentZipKin(){
        String result = restTemplate.getForObject(payment_url+"/payment/zipkin/",String.class);
        return result;
    }
}
