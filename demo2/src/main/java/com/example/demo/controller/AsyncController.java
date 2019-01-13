package com.example.demo.controller;

import com.example.demo.task.AsyncTest;
import com.example.demo.utils.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * 异步任务测试
 * @Author: SiJie Zhi
 * @Date: 2019/1/12 19:11
 */
@RestController
public class AsyncController {

    @Resource
    public AsyncTest asyncTest;
    @RequestMapping("/testAsync")
    public ResultData testAsync() throws InterruptedException {
        long start= System.currentTimeMillis();

       Future<String>  task1= asyncTest.asyncTest1();
        Future<String> task2= asyncTest.asyncTest2();
        Future<String> task3= asyncTest.asyncTest3();
        for(;;){
            if(task1.isDone()){
                break;
            }
        }
        long end= System.currentTimeMillis();
        System.out.println("控制层时间："+(end-start));
        return new ResultData(200,"success");
    }
}
