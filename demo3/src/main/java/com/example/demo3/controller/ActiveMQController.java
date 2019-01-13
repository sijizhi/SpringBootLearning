package com.example.demo3.controller;

import com.example.demo3.Tools.JsonData2;
import com.example.demo3.service.ProductService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/13 17:38
 */

@RestController
public class ActiveMQController {

    @Resource
    private ProductService ProductService;
    @RequestMapping("order")
    public JsonData2 testActiveMQ(String msg){
        Destination destination=new ActiveMQQueue("order.queue");
        ProductService .sendMessage(destination,msg );
        return  JsonData2.buildSuccess();
    }

    @RequestMapping("common")
    public JsonData2  common(String msg)throws  Exception{
        ProductService .sendMessage(msg );
        return  JsonData2.buildSuccess();
    }
}

