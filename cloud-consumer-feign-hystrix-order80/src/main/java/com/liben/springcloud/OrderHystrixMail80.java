package com.liben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liben
 * @date 2020/4/24 13:56
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //开启熔断
public class OrderHystrixMail80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMail80.class,args);
    }
}
