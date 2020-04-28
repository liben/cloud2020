package com.liben.springcloud.dao;

import com.liben.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liben
 * @date 2020/4/16 15:44
 */
@Mapper
public interface PaymentDao {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
