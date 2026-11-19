package org.example.springtransdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private int id;
    private  String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
