package com.liben.springcloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liben
 * @date 2020/4/28 13:35
 */
@Mapper
public interface StorageDao {
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
