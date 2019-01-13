package com.example.demo3.service.Impl;

import com.example.demo3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/13 17:42
 */
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private Queue queue;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;//用来发送消息到broker的对象
    /**
     * 指定队列发送消息
     * @param destination
     * @param msg
     */
    @Override
    public void sendMessage(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination,msg );
    }
    /**
     * 默认队列发送消息
     * @param msg
     */
    @Override
    public void sendMessage(String msg) throws  Exception{
        jmsMessagingTemplate.convertAndSend(msg );
    }
}
