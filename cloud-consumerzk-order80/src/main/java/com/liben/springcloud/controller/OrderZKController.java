package com.liben.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/21 15:32
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
