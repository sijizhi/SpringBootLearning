package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/12 19:03
 */
@Component
@Async
public class AsyncTest {

    public Future<String> asyncTest1() throws InterruptedException {
        long start =System.currentTimeMillis();
        Thread.sleep(1000L);
        long end =System.currentTimeMillis();
        System.out.println("异步任务1:"+(end-start));
        return new AsyncResult<>("异步任务1:"+(end-start));
    }

    public Future<String> asyncTest2() throws InterruptedException {
        long start =System.currentTimeMillis();
        Thread.sleep(2000L);
        long end =System.currentTimeMillis();
        System.out.println("异步任务2:"+(end-start));
        return new AsyncResult<>("异步任务2:"+(end-start));
    }


    public Future<String> asyncTest3() throws InterruptedException {
        long start =System.currentTimeMillis();
        Thread.sleep(3000L);
        long end =System.currentTimeMillis();
        System.out.println("异步任务3:"+(end-start));
        return new AsyncResult<>("异步任务3:"+(end-start));
    }
}
