package com.wxz.personal.myproject.controller;

public class LoginUser {

    private String username;
    private String password;

    public LoginUser(){
        this.username = "wxz";
        this.password = "123456";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
