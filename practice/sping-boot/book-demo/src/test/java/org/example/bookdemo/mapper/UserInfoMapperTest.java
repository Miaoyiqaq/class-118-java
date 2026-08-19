package org.example.bookdemo.mapper;

import org.example.bookdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Test
    void queryUserInfoByName() {
        System.out.println(userInfoMapper.queryUserInfoByName("admin"));
    }
}