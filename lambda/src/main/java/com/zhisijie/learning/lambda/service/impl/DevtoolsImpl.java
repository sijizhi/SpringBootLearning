package com.zhisijie.learning.lambda.service.impl;

import com.zhisijie.learning.lambda.service.Devtools;
import org.springframework.stereotype.Service;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/13 12:14
 */
@Service
public class DevtoolsImpl implements Devtools {
    @Override
    public void test() {
        System.out.println("devtools>>>>>>>>>>>>");
    }
}
