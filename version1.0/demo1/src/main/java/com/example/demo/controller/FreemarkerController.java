package com.example.demo.controller;

import com.example.demo.entity.TestSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/23 13:57
 */
@Controller
@RequestMapping("/free")
public class FreemarkerController {

    @Autowired
    private TestSetting setting;

    @GetMapping("/api/freemarker")
    public String testFreemarker(ModelMap modelMap){
        List list=new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        Map<String,Object> map=new HashMap<>();
        map.put("list",list );
        modelMap.addAttribute("setting", setting);
        modelMap.addAttribute("adv", map);
        return "fm/user/user";
    }
}

