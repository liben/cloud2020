package com.liben.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liben
 * @date 2020/4/27 12:53
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "--------testB";
    }

    @GetMapping("/getHotKey")
    @SentinelResource(value = "getHotKey",blockHandler = "deal_getHotKey")
    public String getHotKey(@RequestParam(value = "p1",required = false) String p1,
                            @RequestParam(value = "p2",required = false) String p2){
        return "-----------testHotKey";
    }

    /**
     * 兜底方法
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String deal_getHotKey(String p1, String p2, BlockException exception){
        return "deal_getHotKey-------------O(∩_∩)O哈哈~";

    }
}
