package com.example.demo.Dao;

import com.example.demo.entity.SijieTest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/24 21:48
 */

public interface SijieMapper {
    //添加信息
    @Insert("insert into SIJIETEST(stid,sname,age)  values(stid.nextVal,#{sname},#{age})")
    @Options(useGeneratedKeys=true, keyProperty="stid", keyColumn="stid")
    public void addSijie(SijieTest sijieTest);

    //删除
    @Delete("delete from SIJIETEST where stid=#{stid}")
    public void deleteSijie(SijieTest sijieTest);

    //所有信息
    @Select("select * from SIJIETEST")
   // @Results({@Result(property = "stid",column = "stid")})
    public List<SijieTest> allSijie();

    //查询单个
    @Select("select * from SIJIETEST where stid=#{stid}")
    public SijieTest oneSijie(SijieTest sijieTest);

    //更新
    @Update("update SIJIETEST set sname=#{sname} where stid=#{stid}")
    public void updateSijie(SijieTest sijieTest);
}
