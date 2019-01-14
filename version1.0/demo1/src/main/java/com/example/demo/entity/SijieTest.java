package com.example.demo.entity;

import java.util.Date;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/24 21:27
 */
public class SijieTest {
    private Integer stid;
    private String sname;
    private String age;
    private Date createDate;

    public SijieTest() {
    }

    public SijieTest(Integer stid, String sname, String age, Date createDate) {
        this.stid = stid;
        this.sname = sname;
        this.age = age;
        this.createDate = createDate;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "SijieTest{" +
                "stid=" + stid +
                ", sname='" + sname + '\'' +
                ", age='" + age + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
