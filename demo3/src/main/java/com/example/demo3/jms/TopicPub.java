package com.example.demo3.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/13 19:26
 */
@Component
public class TopicPub {
    @JmsListener(destination = "video.topic",containerFactory = "jmsListenerContainerTopic")
    public void topic1(String text){
        System.out.println("订阅者1："+text);
    }
    @JmsListener(destination = "video.topic",containerFactory = "jmsListenerContainerTopic")
    public void topic2(String text){

        System.out.println("订阅者2："+text);
    }
    @JmsListener(destination = "video.topic")
    public void topic3(String text){

        System.out.println("订阅者3："+text);
    }
}
