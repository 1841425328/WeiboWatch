package com.example.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;    //用户名/账号
    private String password;    //第一次输入的密码
    private String password1;    //第二次输入的密码
    private String sex;         //性别
    private int status;         //用户当前状态，默认为1
}
