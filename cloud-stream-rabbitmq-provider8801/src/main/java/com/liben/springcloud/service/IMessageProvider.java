package com.liben.springcloud.service;

/**
 * @author liben
 * @date 2020/4/26 0:22
 */
public interface IMessageProvider {
    /**
     * 消息的发送
     * @return
     */
    public String send();
}
