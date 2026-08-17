package org.example.mybatisdemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    public UserInfo(String userName, String password, Integer age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }
}
