package com.example.demo3.controller;

import com.example.demo3.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/15 9:42
 */
@RestController
public class Lambda {

    @RequestMapping("/testLambda")
    public List test(){
        List<User> list= new ArrayList<>();
        list.add(new User("1","小植1" ));
        list.add(new User("2","小植2" ));
        list.add(new User("3","小植3" ));
        list.add(new User("4","小植4" ));
        list.add(new User("5","小植5" ));
        list.forEach(li->{
            System.out.println(li.getId());
        });
        return list;
    }



}
