package com.zhisijie.learning.lambda;

import com.zhisijie.learning.lambda.service.LambadaService;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/3/12 23:10
 */
public class LambdaTest {
    public static void main(String[] args) {
        //在主方法可行
        LambadaService lambadaService=(i) ->  System.out.println(">>>>>>>>>>>>>>>>"+i);
        lambadaService.testLambdaUser("5555");
    }
}
