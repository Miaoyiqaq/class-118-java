package org.example.mybatisdemo.mapper;

import org.example.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest()
class UserInfoMapperXMLTest {
    @Autowired
    private UserInfoMapperXML userInfoMapperXML;
    @Test
    void getList() {
        System.out.println(userInfoMapperXML.getList());
    }

    @Test
    void getUserInfoId() {
        System.out.println(userInfoMapperXML.getUserInfoId(1));
    }

    @Test
    void getListByNameAndPassword() {
        System.out.println(userInfoMapperXML.getListByNameAndPassword("admin", "admin"));
    }

    @Test
    void getListByNameAndPassword2() {
        System.out.println(userInfoMapperXML.getListByNameAndPassword2("admin", "admin"));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo("aaa","bbb",14);
        userInfoMapperXML.insertUser(userInfo);
    }

    @Test
    void deleteUserById() {
        System.out.println(userInfoMapperXML.deleteUserById(8));
    }

    @Test
    void updateUserById() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setUserName("aaa");
        userInfoMapperXML.updateUserById(userInfo);
    }
}