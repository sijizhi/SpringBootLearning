package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {

    @JsonIgnore //忽略
    private String pwd;
    @JsonProperty("dwead")//换名在前端显示，为了安全
    private Long userid;
    @JsonInclude(JsonInclude.Include.NON_NULL)//没有不显示
    private Integer age;
    private Long phone;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+08")//时间格式化
    private Date borthday;

    public UserBean() {
        super();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getBorthday() {
        return borthday;
    }

    public void setBorthday(Date borthday) {
        this.borthday = borthday;
    }

    public UserBean(String pwd, Long userid, Integer age, Long phone, Date borthday) {
        this.pwd = pwd;
        this.userid = userid;

        this.phone = phone;
        this.borthday = borthday;
    }
}
