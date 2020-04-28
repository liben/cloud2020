package com.liben.springcloud.controller;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;
import com.liben.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liben
 * @date 2020/4/16 15:52
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("开始插入数据结果为{}",result);
        if (result>0){
        return new CommonResult(200,"插入成功,serverPort"+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查找结果为: "+payment);
        if(payment != null){
            return new CommonResult(200,"查找成功,serverPort"+serverPort,payment);
        }else{
            return new CommonResult(444,"查找为空,查找ID为: "+id,null);
        }
    }

    /**
     * 服务发现
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services ){
            log.info("*************元素都有：" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("************实例：" +instance.getServiceId()+"\t" + instance.getHost()+"\t"
            +instance.getPort()+"\t" +instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/lb")
    public String getPaymentLB(){
            return serverPort;
    }

    /**
     * 故意超时控制
     * @return
     */
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }


    /**
     * 链路跟踪调用方法
     * @return
     */
    @GetMapping("/zipkin")
    public String paymentZipKin(){
        return "hi,i am paymentZipKin server fall back,welcome to liben ,O(∩_∩)O哈哈~";
    }
}
