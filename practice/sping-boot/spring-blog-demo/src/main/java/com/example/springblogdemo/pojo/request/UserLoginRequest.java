package com.example.springblogdemo.pojo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserLoginRequest {
    @NotNull(message = "用户名不能为空")
    @Length(min = 2, max = 10, message = "用户名长度在2到10个字符之间")
    private String userName;
    @NotNull(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度在6到20个字符之间")
    private String password;
}
