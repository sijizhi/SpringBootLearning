package com.example.demo3.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/13 18:11
 */
@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text){
        System.out.println("orderConsumer收到的报文是："+text);
    }
}

