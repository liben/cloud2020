package com.liben.springcloud.service.impl;

import com.liben.springcloud.dao.PaymentDao;
import com.liben.springcloud.entities.Payment;
import com.liben.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/16 15:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {

        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
