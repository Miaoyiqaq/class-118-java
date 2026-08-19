package org.example.bookdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer UserId;
    private String UserName;
    private String UserPassword;
    private Integer UserDeleteFlag;
    private Date UserCreateTime;
    private Date UserUpdateTime;
}
