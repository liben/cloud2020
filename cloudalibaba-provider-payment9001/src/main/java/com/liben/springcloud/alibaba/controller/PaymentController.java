package com.liben.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liben
 * @date 2020/4/26 17:10
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "注册到阿里巴巴的nanos,serverPort:"+serverPort +"\t id :"+ id;
    }
}
