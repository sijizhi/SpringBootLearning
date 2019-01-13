package com.example.demo.Service.Impl;

import com.example.demo.Dao.SijieMapper;
import com.example.demo.Service.SijieService;
import com.example.demo.entity.SijieTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED)
    public SijieTest addSijie(SijieTest sijieTest) {
        sijieMapper.addSijie(sijieTest);
       // int a=19/0;
        return sijieTest;
    }

    @Override
    public void deleteSijie(SijieTest sijieTest) {
        sijieMapper.deleteSijie(sijieTest);
    }
}
