package com.example.demo.Service.Impl;

import com.example.demo.Dao.SijieMapper;
import com.example.demo.Service.SijieService;
import com.example.demo.entity.SijieTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/24 21:56
 */
@Component
public class SijieServiceImpl implements SijieService {
    @Resource
    private SijieMapper sijieMapper;
    @Override
    public SijieTest addSijie(SijieTest sijieTest) {
        sijieMapper.addSijie(sijieTest);
        return sijieTest;
    }

    @Override
    public void deleteSijie(SijieTest sijieTest) {
        sijieMapper.deleteSijie(sijieTest);
    }
}
