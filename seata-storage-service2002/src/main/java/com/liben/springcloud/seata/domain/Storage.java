package com.liben.springcloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liben
 * @date 2020/4/28 13:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}

