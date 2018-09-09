package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping("/testException")
    public Object testException(){
        int i=8/0;

        return "能输出此信息则没有异常";
    }



}
