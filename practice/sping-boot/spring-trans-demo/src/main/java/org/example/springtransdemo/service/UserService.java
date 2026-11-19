package org.example.springtransdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springtransdemo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public Integer registryUser(String name,String password){
        //插入用户信息​
        return userInfoMapper.insert(name,password);
    }
}