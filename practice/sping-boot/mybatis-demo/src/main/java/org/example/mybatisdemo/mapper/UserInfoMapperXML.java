package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.example.mybatisdemo.model.UserInfo;

import java.util.List;
@Mapper
public interface UserInfoMapperXML {

    List<UserInfo> getList();




    //查一条数据;使用对象接收

    UserInfo getUserInfoId(Integer id);
    //查多条数据;使用List接收

    List<UserInfo> getListByNameAndPassword(String username, String password);
    //重命名参数.使用@Param

    List<UserInfo> getListByNameAndPassword2(@Param("usn")String username, @Param("pad")String password);


    Integer insertUser(UserInfo userInfo);


    Integer deleteUserById(Integer id);


    Integer updateUserById(UserInfo userInfo);


}
