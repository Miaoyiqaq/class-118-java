package com.example.springblogdemo.mapper;

import com.example.springblogdemo.pojo.dataobject.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author my
* @description 针对表【user_info(用户表)】的数据库操作Mapper
* @createDate 2026-10-12 11:14:41
* @Entity com.example.springblogdemo.pojo.dataobject.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




