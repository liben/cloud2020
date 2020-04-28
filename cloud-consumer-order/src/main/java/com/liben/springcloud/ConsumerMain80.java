package com.liben.springcloud;

import com.liben.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author liben
 * @date 2020/4/16 16:53
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration=MySelfRule.class)
public class ConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class,args);
    }
}
