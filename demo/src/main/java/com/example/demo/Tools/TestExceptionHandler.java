package com.example.demo.Tools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 全局异常类
 */

@RestControllerAdvice//异常返回json
public class TestExceptionHandler {

    //控制台打印日志
    private static final Logger LOG= LoggerFactory.getLogger(TestExceptionHandler.class);

    //捕获全局异常，处理所有不可知的异常
    @ExceptionHandler(value = Exception.class)
    public Object handleException(Exception e, HttpServletRequest request){
        //控制台打印异常，方便开发人员
        LOG.error("url异常接口是：{}, message信息是：{}",request.getRequestURL(),e.getMessage());
        Map<String,Object> map=new HashMap<>();
            map.put("code",100 );
            map.put("message",e.getMessage());
            map.put("url",request.getRequestURL() );//异常路径（接口）
        return map;//异常时返回给前端
    }


    //捕获全局异常(MyException)
    @ExceptionHandler(value = MyException.class)
    public Object handleMyException(MyException e, HttpServletRequest request){
        //控制台打印异常，方便开发人员
        LOG.error("url异常接口是：{}, message信息是：{}",request.getRequestURL(),e.getMsg());

        //进行页面跳转
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg",e.getMsg());
//        return modelAndView;

        Map<String,Object> map=new HashMap<>();
        map.put("code",e.getCode() );
        map.put("message",e.getMsg());
        map.put("url",request.getRequestURL() );//异常路径（接口）
        return map;//异常时返回给前端
    }



}
