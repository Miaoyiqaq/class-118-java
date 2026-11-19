package com.example.springblogdemo.service;

import com.example.springblogdemo.pojo.dataobject.BlogInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import com.example.springblogdemo.pojo.request.UpdateBlogRequest;
import com.example.springblogdemo.pojo.response.BlogInfoResponse;
import com.example.springblogdemo.pojo.response.UserInfoResponse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
* @author my
* @description 针对表【blog_info(博客表)】的数据库操作Service
* @createDate 2026-10-12 11:14:40
*/
public interface BlogInfoService extends IService<BlogInfo> {

    List<BlogInfoResponse> getListByDesc();

    BlogInfoResponse getBlogDetail(Integer blogId);

    boolean addBlog(AddBlogInfoRequest addBlogInfoRequest);

    boolean updateBlog(UpdateBlogRequest updateBlogRequest);

    boolean delete(@NotNull(message="博客ID不能为空") Integer blogId);
}