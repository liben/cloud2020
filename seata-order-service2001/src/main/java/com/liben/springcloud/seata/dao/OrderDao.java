package com.liben.springcloud.seata.dao;

import com.liben.springcloud.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liben
 * @date 2020/4/28 11:46
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态
    void update(@Param("userId") Long userId, @Param("status")Integer status);


}
