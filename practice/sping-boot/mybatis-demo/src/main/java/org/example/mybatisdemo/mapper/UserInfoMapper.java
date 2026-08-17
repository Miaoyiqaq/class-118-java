package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.example.mybatisdemo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    //查全表
//    @ResultMap("BaseMap")
    @Select("select * from user_info")
    List<UserInfo> getList();
//    @Results(id = "BaseMap", value = {
//            @Result(column = "delete_flag", property = "deleteFlag"),
//            @Result(column = "create_flag", property = "createFlag"),
//            @Result(column = "update_flag", property = "updateFlag")
//    })
    @Select("select * from user_info")
    List<UserInfo> getList2();


    //查一条数据;使用对象接收
    @Select("select * from user_info where id = #{?}")
    UserInfo getUserInfoId(Integer id);
    //查多条数据;使用List接收
    @Select("select * from user_info where username = #{username} and password = #{password}")
    List<UserInfo> getListByNameAndPassword(String username, String password);
    //重命名参数.使用@Param
    @Select("select * from user_info where username = #{usn} and password = #{pad}")
    List<UserInfo> getListByNameAndPassword2(@Param("usn")String username, @Param("pad")String password);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_info (`username`, `password`, `age`) values( #{userName}, #{password} ,#{age})")
    Integer insertUser(UserInfo userInfo);

    @Delete("delete from user_info where id = #{id}")
    Integer deleteUserById(Integer id);

    @Update("update user_info set username = #{userName} where id = #{id}")
    Integer updateUserById(UserInfo userInfo);
    //对象重命名需要使用对象来进行引用
    @Update("update user_info set username = #{userInfo.userName} where id = #{userInfo.id}")
    Integer updateUserById2(@Param("userInfo")UserInfo userInfo);
}
