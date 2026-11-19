package com.example.springblogdemo.service;

import com.example.springblogdemo.pojo.dataobject.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springblogdemo.pojo.request.UserLoginRequest;
import com.example.springblogdemo.pojo.response.UserInfoResponse;
import com.example.springblogdemo.pojo.response.UserLoginResponse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
* @author my
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2026-10-12 11:14:41
*/
public interface UserInfoService extends IService<UserInfo> {

    UserLoginResponse login(UserLoginRequest userLoginRequest);

    UserInfoResponse getUserInfo(@NotNull(message = "用户ID不能为空") Integer userId);

    UserInfoResponse getAuthorInfo(@NotNull(message = "博客ID不能为空") @Min(value = 1, message = "博客ID不能小于1") Integer blogId);
}
