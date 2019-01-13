package com.example.demo.controller;

import com.example.demo.Dao.SijieMapper;
import com.example.demo.Service.SijieService;
import com.example.demo.entity.SijieTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/24 23:24
 */
@RestController
public class MybatisController {

    @Autowired
    private SijieService sijieService;
    @Resource
    private SijieMapper sijieMapper;

    @GetMapping("/add_sijie")
    public Object addSijie(SijieTest sijieTest){
        System.out.println(sijieTest);
        sijieTest=sijieService.addSijie(sijieTest);

        return sijieTest;
    }

    @GetMapping("/del_sijie")
    public String delSijie(SijieTest sijieTest){
        System.out.println(sijieTest);
        sijieService.deleteSijie(sijieTest);

        return "已删除";
    }

    @GetMapping("/all_sijie")
    public Object allSijie(){
      return sijieMapper.allSijie();
    }

    @GetMapping("/one_sijie")
    public Object oneSijie(SijieTest sijieTest){
        return sijieMapper.oneSijie(sijieTest);
    }

    @GetMapping("/update_sijie")
    public Object updateSijie(SijieTest sijieTest){
        sijieMapper.updateSijie(sijieTest);
        return "已经更新";
    }
}
