package com.zhisijie.learning.lambda.entity;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/3/12 22:05
 */
public class User {
    private String usercode;
    private String password;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String usercode, String password) {
        this.usercode = usercode;
        this.password = password;
    }

    public User() {
    }
}
