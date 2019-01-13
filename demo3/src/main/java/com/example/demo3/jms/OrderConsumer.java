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
        System.out.println("order.queue第3个人调用了："+text);
    }

    @JmsListener(destination = "order.queue")
    public void receiveQueue2(String text){
        System.out.println("order.queue第1个人调用了："+text);
    }
    @JmsListener(destination = "common.queue")
    public void common(String text){
        System.out.println("common.queue收到的报文是："+text);
    }
}

