package com.example.springblogdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springblogdemo.common.Constants;
import com.example.springblogdemo.common.exception.BlogException;
import com.example.springblogdemo.common.util.BeanTrans;
import com.example.springblogdemo.mapper.UserInfoMapper;
import com.example.springblogdemo.pojo.dataobject.BlogInfo;
import com.example.springblogdemo.pojo.dataobject.UserInfo;
import com.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import com.example.springblogdemo.pojo.request.UpdateBlogRequest;
import com.example.springblogdemo.pojo.response.BlogInfoResponse;
import com.example.springblogdemo.pojo.response.UserInfoResponse;
import com.example.springblogdemo.service.BlogInfoService;
import com.example.springblogdemo.mapper.BlogInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.springblogdemo.common.util.BeanTrans.trans;

/**
* @author my
* @description 针对表【blog_info(博客表)】的数据库操作Service实现
* @createDate 2026-10-12 11:14:40
*/
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo>
    implements BlogInfoService{

    @Autowired
    private BlogInfoMapper blogInfoMapper;
    private UserInfoMapper userInfoMapper;
    @Override
    public List<BlogInfoResponse> getListByDesc() {
        //调用数据库
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getDeleteFlag, Constants.NOT_DELETE).orderByDesc(BlogInfo::getId));

        //转换数据格式
        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream().map(blogInfo-> trans(blogInfo)).toList();
        return blogInfoResponses;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        BlogInfo blogInfo = blogInfoMapper.selectOne(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getId, blogId)
                .eq(BlogInfo::getDeleteFlag,Constants.NOT_DELETE));
        if(blogInfo == null) {
            throw new BlogException("博客不存在");
        }
        return trans(blogInfo);
    }

    @Override
    public boolean addBlog( AddBlogInfoRequest addBlogInfoRequest) {
        BlogInfo blogInfo = trans(addBlogInfoRequest);
        try {
            Integer result = blogInfoMapper.insert(blogInfo);
            return result == 1;
        } catch (Exception e) {
            log.warn("博客添加失败");
            return false;
        }
    }

    @Override
    public boolean updateBlog(UpdateBlogRequest updateBlogRequest) {
        BlogInfo blogInfo = trans(updateBlogRequest);
        try {
            Integer result = blogInfoMapper.updateById(blogInfo);
            return result == 1;

        } catch (Exception e) {
            log.warn("博客更新失败");
            return false;
        }
    }

    @Override
    public boolean delete(Integer blogId) {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(Constants.IS_DELETE);
        try {
            blogInfoMapper.updateById(blogInfo);
        } catch (Exception e) {
            log.warn("博客删除失败");
            return false;
        }
        return true;
    }
}




