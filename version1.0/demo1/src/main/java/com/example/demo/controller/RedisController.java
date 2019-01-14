package com.example.demo.controller;

import com.example.demo.Tools.JsonUtils;
import com.example.demo.Tools.RedisClient;
import com.example.demo.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 测试springboot 集成redis
 * @Author: Sijie Zhi
 * @Date: 2018/11/14 10:45
 */
@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redistl;
    @Autowired
    private RedisClient redisClient;//自己封装的redis工具类（StringRedisTemplate常用的方法）

    /**
     * 设置redis key-value
     * @return
     */
    @RequestMapping("/addRedis")
    public String addRedis(){
//        redistl.opsForValue().set("springbootredis","springbootredis 和之前学的jedis的写不一样" );
        redisClient.set("springbootredis","自己使用自己封装类set的键值");
        UserBean userBean=new UserBean();
        userBean.setAge(19);
        userBean.setBorthday(new Date());
        userBean.setPhone(15502117007L);
        userBean.setUserid(122L);
        userBean.setPwd("abc123");
       // redistl.opsForValue().set("userbean",JsonUtils.obj2String(userBean) );
        redisClient.set("base:user:timeout:11",JsonUtils.obj2String(userBean),60);
       // redisClient.set("userbean",JsonUtils.obj2String(userBean));
        return null;
    }

    /**
     * 获取redis
     * @return
     */
    @RequestMapping("/getRedis")
    public String getRedis(){
        //return  redistl.opsForValue().get("springbootredis");

       return  redisClient.get("springbootredis");
    }


    /**
     * 获取redis -user对象
     * @return
     */
    @RequestMapping("/getuser")
    public UserBean getuser(){
        UserBean userbean=JsonUtils.string2Obj(redistl.opsForValue().get("userbean"), UserBean.class);
        return  userbean;
    }
    /**
     * 获取有效时间
     * @return
     */
    @RequestMapping("/getTimeout")
    public Long getTimeout(){
        //return  redistl.opsForValue().get("springbootredis");

        return  redistl.getExpire("timeout");
    }



    /**
     * 删除key
     * @return
     */
    @RequestMapping("/deletekey")
    public Boolean deletekey(){
        //return  redistl.opsForValue().get("springbootredis");

        return  redistl.delete("springbootredis");
    }

}
