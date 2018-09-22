package com.example.demo.Tools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        LOG.error("url异常接口是：{},message信息是：{}",request.getRequestURL(),e.getMessage());
        Map<String,Object> map=new HashMap<>();
            map.put("code",100 );
            map.put("message",e.getMessage());
            map.put("url",request.getRequestURL() );//异常路径（接口）
        return map;//异常时返回给前端
    }



}
