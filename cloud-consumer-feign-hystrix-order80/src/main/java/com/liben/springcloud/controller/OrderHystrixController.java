package com.liben.springcloud.controller;
import com.liben.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/24 13:58
 */
@RestController
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {

    @Resource private PaymentHystrixService paymentHystrixService;
    /**
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    /**
     * 服务降级
     * @return
     */
    public String paymentTimeoutFallbackMethod(){
        return "我是消费端80，对方支付系统繁忙，请10秒钟后重试再试或者自己运行出错，请检查O(∩_∩)O哈哈~";
    }

    //下面是全局fallback
    public String payment_global_fallbackMethod(){
        return "global异常信息处理，请稍后再试 O(∩_∩)O哈哈~";
    }
}
