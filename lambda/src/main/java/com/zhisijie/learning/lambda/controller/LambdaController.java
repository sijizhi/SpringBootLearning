package com.zhisijie.learning.lambda.controller;

import com.zhisijie.learning.lambda.entity.User;
import com.zhisijie.learning.lambda.service.Devtools;
import com.zhisijie.learning.lambda.service.LambadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/3/12 22:06
 */
@RestController
public class LambdaController {

    @Autowired
    Devtools devtools;

    LambadaService lambadaService=(i) ->  System.out.println(">>>>>>>>>>>>>>>>"+i);
    @RequestMapping("/testLambda")
    public String testLambda(String user){
        System.out.println("lalalla devtools");
        System.out.println("lalalla devtools");
        System.out.println("lalalla devtools");
        devtools.test();
        lambadaService.testLambdaUser(user);
        return  user;
    }

}
