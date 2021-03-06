package com.liben.springcloud.seata.service;

import com.liben.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;

/**
 * @author liben
 * @date 2020/4/28 12:32
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping(value = "account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);

}
