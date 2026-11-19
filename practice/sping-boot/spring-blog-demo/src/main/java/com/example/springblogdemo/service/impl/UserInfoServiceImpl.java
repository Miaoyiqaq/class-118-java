package com.example.springblogdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springblogdemo.common.Constants;
import com.example.springblogdemo.common.exception.BlogException;
import com.example.springblogdemo.common.util.BeanTrans;
import com.example.springblogdemo.common.util.JwtUtils;
import com.example.springblogdemo.common.util.SecurityUtils;
import com.example.springblogdemo.mapper.BlogInfoMapper;
import com.example.springblogdemo.pojo.dataobject.BlogInfo;
import com.example.springblogdemo.pojo.dataobject.UserInfo;
import com.example.springblogdemo.pojo.request.UserLoginRequest;
import com.example.springblogdemo.pojo.response.UserInfoResponse;
import com.example.springblogdemo.pojo.response.UserLoginResponse;
import com.example.springblogdemo.service.UserInfoService;
import com.example.springblogdemo.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author my
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2026-10-12 11:14:41
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    /***
     * 校验账号密码,正确则生成令牌
     */
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        UserInfo userInfo = selectUserInfoByName(userLoginRequest.getUserName());
        if(userInfo ==null || userInfo.getId() == null) {
            throw new BlogException("用户不存在");
        }
//        旧的验证逻辑
//        if(!userLoginRequest.getPassword().equals(userInfo.getPassword())) {
//            throw new BlogException("用户名或密码错误");
//        }
        if(!SecurityUtils.verify(userLoginRequest.getPassword(), userInfo.getPassword())) {
            throw new BlogException("用户名或密码错误");
        }
        String token = JwtUtils.genJwt(String.valueOf(userInfo.getId()), userInfo.getUserName());;
        return new UserLoginResponse(userInfo.getId(), token);
    }

    @Override
    public UserInfoResponse getAuthorInfo(Integer blogId) {
        BlogInfo blogInfo = getBlogInfoById(blogId);
        if(blogInfo == null) {
            throw new BlogException("博客不存在");
        }
        return getUserInfo(blogInfo.getUserId());
    }
    @Override
    public UserInfoResponse getUserInfo(Integer userId) {
        UserInfo userInfo = getUserInfoById(userId);
        if(userInfo == null) {
            throw new BlogException("用户不存在");
        }
        return BeanTrans.trans(userInfo);
    }

    public UserInfo getUserInfoById(Integer userId) {
        return userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getId, userId)
                .eq(UserInfo::getDeleteFlag, Constants.NOT_DELETE)
        );
    }
    public BlogInfo getBlogInfoById(Integer blogId) {
        BlogInfo blogInfo = blogInfoMapper.selectOne(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getId, blogId)
                .eq(BlogInfo::getDeleteFlag,Constants.NOT_DELETE));
        return blogInfo;
    }
    private UserInfo selectUserInfoByName(String username) {
         return userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserName, username)
                .eq(UserInfo::getDeleteFlag, Constants.NOT_DELETE)
        );
    }
}




