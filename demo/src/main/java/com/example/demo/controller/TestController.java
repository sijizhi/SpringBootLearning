package com.example.demo.controller;

import com.example.demo.entity.UserBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    Map map=new HashMap();
    @GetMapping("/test")
    public String TestReturn(){
        System.out.println("TestController测试连接==========");
        return "我是植思杰，我来测试springboot";
    }

    /**
     *
     * @param userid
     * @param partid
     * @return
     */
    @GetMapping("/test/{user_id}/{part_id}")
    public Map TestMap(@PathVariable("user_id") String userid,
                       @PathVariable("part_id") String partid){
        map.put("userid",userid);
        map.put("partid",partid);

        System.out.println("我用了热部署及触发器了！！！！！");
        System.out.println("确实强大呀！！！！！");
        return  map;
    }

    @GetMapping("/get_header/{userid}")
    public Map httpHeader(@PathVariable  String userid, @RequestHeader("access_heard") String accessHeard){
        map.put("userid",userid);
        map.put("accessHeard",accessHeard);
        return  map;
    }

    @GetMapping("/getJackJson")
    public UserBean getJackJson(){
        UserBean user=new UserBean( "abc123", 155l, 16, 15502117007l, new Date());

        return  user;
    }

    @GetMapping("/testFilter/test")
    public String testFilter(){
        return  "测试通过";
    }

    @GetMapping("/api/test")
    public String testInterceptor(){
        System.out.println("========拦截controller===========");
        return  "拦截通过";
    }

}
