package com.example.demo3.entity;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/14 17:16
 */
public class User {

    private String id;

    private String name;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }





}

