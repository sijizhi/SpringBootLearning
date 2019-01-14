package com.example.demo.controller;

import com.example.demo.Service.SijieService;
import com.example.demo.Tools.MD5Util;
import com.example.demo.entity.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Autowired
    private SijieService sijieService;
    Map map=new HashMap();

    /**
     * 日志打印
     * @return
     */
    @GetMapping("/test")
    public String TestReturn(){
        System.out.println("TestController测试连接==========");
        logger.debug("this is debug level");
        logger.info("this is info level ");
        logger.warn("this is warn level ");
        logger.error("this is error level");
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

    /**
     * MD5
     */

    @GetMapping("/testMD5")
    public String testMD5(String string){
       String string1= MD5Util.md5(string);
       String result1="bbf2dead374654cbb32a917afd236656";
       String result2="bbf2dead374654cbb32a917afd236656";
        return MD5Util.md5(string);
    }

    /**
     * MD5
     */

    @GetMapping("/passwordEncoder")
    public String passwordEncoder(String string){
        String test1=passwordEncoder.encode(string);
        String test2="$2a$10$4so92gEv/fM70p4ynle3Ie.Le5cjWhBW6E3oeA4IE9lij7JCA0mra";
        String result="";
        if (passwordEncoder.matches(string, test2)){
            result="true";
        }else {
        result="false";
    }

        return passwordEncoder.encode(string);
}



}
