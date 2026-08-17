package org.example.mybatisdemo.mapper;

import jdk.swing.interop.SwingInterOpUtils;
import lombok.val;
import org.example.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void getList() {
        List<UserInfo> list = userInfoMapper.getList();
        list.stream().forEach(x->System.out.println(x));
    }

    @Test
    void getUserInfoId() {
        UserInfo userInfo = userInfoMapper.getUserInfoId(3);
        System.out.println(userInfo);
    }

    @Test
    void getListByNameAndPassword() {
        System.out.println(userInfoMapper.getListByNameAndPassword("admin","admin"));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo("miao","1234",18);
        Integer insert = userInfoMapper.insertUser(userInfo);
        System.out.println(insert);
    }

    @Test
    void deleteUserById() {
        System.out.println(userInfoMapper.deleteUserById(7));
    }

    @Test
    void updateUserById() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setUserName("mmm");
        System.out.println(userInfoMapper.updateUserById(userInfo));
    }

    @Test
    void getList2() {
        List<UserInfo> list = userInfoMapper.getList2();
        list.stream().forEach(x->System.out.println(x));
    }
}