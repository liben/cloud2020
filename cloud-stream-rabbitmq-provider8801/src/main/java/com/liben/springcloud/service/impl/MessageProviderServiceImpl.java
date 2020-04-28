package com.liben.springcloud.service.impl;

import com.liben.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author liben
 * @date 2020/4/26 0:23
 */

@EnableBinding({Source.class})  //定义生产者的绑定器,定义消息的推送管道
@Slf4j
public class MessageProviderServiceImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        //发送一个流水号
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//组装message发送
        log.info("**********消息发送：serial :" + serial);
        return null;
    }
}
