package com.zhisijie.learning.lambda.controller;

import com.zhisijie.learning.lambda.entity.User;
import com.zhisijie.learning.lambda.service.LambadaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/3/12 22:06
 */
@RestController
public class LambdaController {

//    @Autowired
//    LambadaService lambadaService;

    LambadaService lambadaService=(i) ->  System.out.println(">>>>>>>>>>>>>>>>"+i);
    @RequestMapping("/testLambda")
    public User testLambda(User user){

        lambadaService.testLambdaUser(user.getPassword());
        return  user;
    }

}
