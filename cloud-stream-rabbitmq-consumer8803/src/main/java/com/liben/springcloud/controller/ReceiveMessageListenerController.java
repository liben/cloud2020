package com.liben.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liben
 * @date 2020/4/26 11:37
 */
@Component
@EnableBinding(Sink.class)//消费者绑定
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    public void input(Message<String> message){
        System.out.println("消费者2号，------》接收消息：" + message.getPayload() + "\t port:" +serverPort);
    }
}
