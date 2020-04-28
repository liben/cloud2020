package com.liben.springcloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author liben
 * @date 2020/4/28 11:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status; //0创建中1已完结

}

