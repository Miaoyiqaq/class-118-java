package org.example.mybatisdemo.service;

import org.example.mybatisdemo.mapper.UserInfoMapper;
import org.example.mybatisdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public List<UserInfo> getUserList(){
        return userInfoMapper.getList();
    }
}
