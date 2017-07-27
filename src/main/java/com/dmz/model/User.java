package com.dmz.model;

/**
 * Created by 豆孟哲 on 2017/7/26.
 */
public class User {
    private  String name;
    private  String password;
    private int id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

