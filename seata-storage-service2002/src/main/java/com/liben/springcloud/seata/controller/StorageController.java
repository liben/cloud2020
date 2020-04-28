package com.liben.springcloud.seata.controller;

import com.liben.springcloud.entities.CommonResult;
import com.liben.springcloud.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/28 13:34
 */
@RestController
@Slf4j
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping(value = "storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult(200, "扣减库存成功");
    }

}
