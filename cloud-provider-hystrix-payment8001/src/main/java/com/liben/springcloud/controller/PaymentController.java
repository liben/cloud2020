package com.liben.springcloud.controller;

import com.liben.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/22 11:38
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result =  paymentService.paymentInfo_OK(id);
        log.info("*********result 正常:" +result);
        return  result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String result =  paymentService.paymentInfo_TimeOut(id);
        log.info("*********result 超时:" +result);
        return  result;
    }


    //============服务熔断

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result 服务熔断" +result);
        return result;
    }
}
