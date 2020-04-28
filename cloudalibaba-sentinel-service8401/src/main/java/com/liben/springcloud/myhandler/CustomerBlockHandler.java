package com.liben.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.entities.Payment;

/**
 * @author liben
 * @date 2020/4/27 15:57
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义,global",new Payment(2020L,"serial003"));
    }
}
