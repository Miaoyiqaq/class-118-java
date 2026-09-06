package org.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.mybatisplusdemo.model.UserInfo;

import java.util.List;

//@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select id, username, password, age from user_info ${ew.customSqlSegment}")
    List<UserInfo> queryUserByCustom(@Param("Constants.WRAPPER") Wrapper<UserInfo> queryWrapper);

}
