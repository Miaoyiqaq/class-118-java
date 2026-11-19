package com.example.springblogdemo.controller;

import com.example.springblogdemo.pojo.request.UserLoginRequest;
import com.example.springblogdemo.pojo.response.UserInfoResponse;
import com.example.springblogdemo.pojo.response.UserLoginResponse;
import com.example.springblogdemo.service.UserInfoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @PostMapping("/login")
    public UserLoginResponse login(@Validated @RequestBody UserLoginRequest userLoginRequest) {//@Validated启动UserLoginRequest的参数校验逻辑
        log.info("用户登录:{}", userLoginRequest.getUserName());
        return userInfoService.login(userLoginRequest);
    }
    @GetMapping("/getUserInfo")
    public UserInfoResponse getUserInfo(@NotNull(message = "用户ID不能为空")@Min(value = 1, message = "用户ID不能小于1") Integer userId){
        log.info("获取用户信息,userID:{}",userId);
        return userInfoService.getUserInfo(userId);
    }
    @GetMapping("/getAuthorInfo")
    public UserInfoResponse getAuthorInfo(@NotNull(message = "博客ID不能为空")@Min(value = 1, message = "博客ID不能小于1") Integer blogId){
        log.info("获取博客信息,blogID:{}",blogId);
        return userInfoService.getAuthorInfo(blogId);
    }
}
