package com.example.springblogdemo.mapper;

import com.example.springblogdemo.pojo.dataobject.BlogInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author my
* @description 针对表【blog_info(博客表)】的数据库操作Mapper
* @createDate 2026-10-12 11:14:40
* @Entity com.example.springblogdemo.pojo.dataobject.BlogInfo
*/
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {

}




