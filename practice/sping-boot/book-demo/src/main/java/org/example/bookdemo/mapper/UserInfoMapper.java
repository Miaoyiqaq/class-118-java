package org.example.bookdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.example.bookdemo.model.UserInfo;
@Mapper
public interface UserInfoMapper {
    @Results(id = "userInfoMap", value={
            @Result(column = "id", property = "UserId"),
//            @Result(column = "user_name", property = "name"),
            @Result(column = "password", property = "UserPassword"),
            @Result(column = "delete_flag", property = "UserDeleteFlag"),
            @Result(column = "create_time", property = "UserCreateTime"),
            @Result(column = "update_time", property = "UserUpdateTime")
    })
    @Select("select * from user_info where user_name=#{userName} and delete_flag=0")
//    @ResultMap("userInfoMap")
    UserInfo queryUserInfoByName(String userName);
}
