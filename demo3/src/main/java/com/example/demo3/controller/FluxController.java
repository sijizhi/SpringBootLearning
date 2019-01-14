package com.example.demo3.controller;

import com.example.demo3.entity.User;
import com.example.demo3.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/14 17:11
 */
@RestController
public class FluxController {

    @RequestMapping("testflux")
    public Mono<String> test(){
        return Mono.just("hello 植思杰");
    }


//    @Autowired
//    private UserService userService;
    private final UserService userService;

    public FluxController(final UserService userService) {
        this.userService=userService;
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping("findbyid")
    public Mono<User> findbyid(final String id){
        return userService.getById(id);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("del")
    public Mono<User> del(final String id){
        return userService.del(id);
    }

    /**
     * 全部用户
     * @return
     */
    @GetMapping(value = "list",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> list(){
//        return userService.list().delayElements(Duration.ofSeconds(2));
        return userService.list();
    }

}
