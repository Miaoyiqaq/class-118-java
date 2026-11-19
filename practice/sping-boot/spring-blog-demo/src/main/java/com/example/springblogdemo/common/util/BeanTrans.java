package com.example.springblogdemo.common.util;

import com.example.springblogdemo.common.exception.BlogException;
import com.example.springblogdemo.pojo.dataobject.BlogInfo;
import com.example.springblogdemo.pojo.dataobject.UserInfo;
import com.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import com.example.springblogdemo.pojo.request.UpdateBlogRequest;
import com.example.springblogdemo.pojo.response.BlogInfoResponse;
import com.example.springblogdemo.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanTrans {
    public static BlogInfoResponse trans(BlogInfo blogInfo) {
        if(blogInfo == null) {
            throw new BlogException("博客内容为空");
        }
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo, blogInfoResponse);
        return blogInfoResponse;
    }

    /***
     * 将UserInfo转化为UserInfoResponse
     * @param userInfo
     * @return
     */
    public static UserInfoResponse trans(UserInfo userInfo) {
        if(userInfo == null) {
            throw new BlogException("用户不存在");
        }
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        BeanUtils.copyProperties(userInfo,userInfoResponse);
        return userInfoResponse;
    }
    public static BlogInfo trans(AddBlogInfoRequest addBlogInfoRequest) {
        if(addBlogInfoRequest == null) {
            throw new BlogException("博客信息不存在");
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(addBlogInfoRequest, blogInfo);
        return blogInfo;
    }
    public static BlogInfo trans(UpdateBlogRequest updateBlogRequest) {
        if(updateBlogRequest == null) {
            throw new BlogException("博客信息不存在");
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(updateBlogRequest, blogInfo);
        return blogInfo;
    }
}
