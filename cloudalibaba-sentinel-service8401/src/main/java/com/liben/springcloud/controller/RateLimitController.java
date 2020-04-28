package com.liben.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;
import com.liben.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liben
 * @date 2020/4/27 15:42
 */
@RestController
public class RateLimitController {
    /**
     * 按照资源名称限流
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handlerException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

/**
 *
 * 按照资源地址URL限流
 */
@GetMapping("/rateLimit/byUrl")
@SentinelResource(value = "byUrl")
public CommonResult byUrl(){
    return new CommonResult(200,"按URL限流测试OK",new Payment(2020L,"serial002"));
}

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial002"));
    }
}
