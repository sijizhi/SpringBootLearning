package com.example.demo.controller;

import com.example.demo.Service.SijieService;
import com.example.demo.Tools.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ExceptionController {

    @Resource
    SijieService sijieService;
    @RequestMapping("/testException")
    public Object testException(){
        int i=8/0;

        return "能输出此信息则没有异常";
    }


    @RequestMapping("/testError")
    public Object myexc(){
        sijieService.addSijie(null);
        throw new MyException("499","my ext异常");
    }


    @RequestMapping("/testCatch")
    public Object myCatch(){
        sijieService.addSijie(null);
        try {
            int t=9/0;
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (MyException e){

        }
        return "Aaaa";
    }
}
