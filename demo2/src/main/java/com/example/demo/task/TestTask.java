package com.example.demo.task;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/12 14:23
 */
@Component
public class TestTask {

//    @Scheduled(fixedRate = 2000)
    public void task(){
        System.out.println("定时任务"+new Date());
    }

}
