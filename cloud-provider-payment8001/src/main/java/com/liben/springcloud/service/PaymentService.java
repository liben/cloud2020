package com.liben.springcloud.service;

import com.liben.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author liben
 * @date 2020/4/16 15:48
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
