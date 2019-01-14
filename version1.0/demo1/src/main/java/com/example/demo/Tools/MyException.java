package com.example.demo.Tools;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/9/11 9:28
 */
public class MyException extends RuntimeException{//继承RuntimeException 异常
    private String code;//定义两个抛异常的信息
    private String msg;

    public MyException() {
    }

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
