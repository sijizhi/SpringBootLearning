package com.example.demo3.service;


import javax.jms.Destination;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/13 17:40
 */
public interface ProductService {

    /**
     * 指定消息队列，还有消息
     * @param destination
     * @param msg
     */
    public void sendMessage(Destination destination, final String msg);

    /**
     * 默认消息队列，发送消息
     * @param msg
     */
    public void sendMessage(final String msg) throws  Exception;

}
