package com.liben.springcloud.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liben
 * @date 2020/4/28 12:36
 */
@Configuration
@MapperScan("com.liben.springcloud.seata.dao")
public class MyBatisConfig {
}
