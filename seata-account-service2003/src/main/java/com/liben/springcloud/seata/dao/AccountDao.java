package com.liben.springcloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author liben
 * @date 2020/4/28 13:44
 */
@Mapper
public interface AccountDao {
    int decrease(@Param("userId") Long userId,
                 @Param("money") BigDecimal money);

}
