package com.liben.springcloud.seata.service;

import com.liben.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liben
 * @date 2020/4/28 12:34
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping("storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);

}
