package com.example.demo3.service.Impl;

import com.example.demo3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

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
        jmsMessagingTemplate.convertAndSend(this.queue,msg );
    }

    //=======发布订阅相关代码=========
    @Resource
    private Topic topic;
    @Override
    public void addtopic(String msg) throws Exception {
        jmsMessagingTemplate.convertAndSend(this.topic,msg );
    }
}
