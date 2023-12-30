package com.example.warehousemanagementsystem.bean;

public class User{
    private int  id;
    private String username;
    private String password;
//    private String email;
//    private String phone;
//    private String address;
//    private String role; // 用户角色，例如“管理员”、“普通用户”等



    // 构造函数、getter和setter方法
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
