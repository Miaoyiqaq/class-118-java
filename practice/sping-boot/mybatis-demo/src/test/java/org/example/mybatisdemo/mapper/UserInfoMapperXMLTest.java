package org.example.mybatisdemo.mapper;

import org.example.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void getListByOrder() {
        System.out.println(userInfoMapperXML.getListByOrder("desc"));
    }

    @Test
    void getListByLike() {
        System.out.println(userInfoMapperXML.getListByLike("a"));
    }

    @Test
    void insertUserInfoByCondition() {
        UserInfo userInfo = new UserInfo("aaa","bbb",14);
        //userInfo.setGender(1);
        userInfo.setPhone("123123123");
        userInfoMapperXML.insertUserInfoByCondition(userInfo);
    }

    @Test
    void queryByCondition() {
        UserInfo userInfo = new UserInfo();
       // userInfo.setAge(18);
//        userInfo.setGender(0);
//        userInfo.setDeleteFlag(0);
        System.out.println(userInfoMapperXML.queryByCondition(userInfo));
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("asd");
        userInfo.setAge(10);
        userInfo.setDeleteFlag(1);
        userInfo.setId(5);
        userInfoMapperXML.updateByCondition(userInfo);
    }

    @Test
    void batchDelete() {
        userInfoMapperXML.batchDelete(List.of(5));
    }
}