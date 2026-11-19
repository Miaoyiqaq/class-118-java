package com.example.springblogdemo.controller;

import com.example.springblogdemo.pojo.request.AddBlogInfoRequest;
import com.example.springblogdemo.pojo.request.UpdateBlogRequest;
import com.example.springblogdemo.pojo.response.BlogInfoResponse;
import com.example.springblogdemo.service.BlogInfoService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {

//    @Resource(name = "blogInfoServiceImpl")
    @Autowired
    private BlogInfoService blogInfoService;

    @GetMapping("/getList")
    public List<BlogInfoResponse> getBlogList(){
        return blogInfoService.getListByDesc();
    }

    @GetMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail(@NotNull(message = "博客ID不能为空") Integer blogId){
        log.info("获取博客详情,ID:{}", blogId);
        return blogInfoService.getBlogDetail(blogId);
    }
    @PostMapping("/add")
    public boolean addBlog(@Validated @RequestBody AddBlogInfoRequest addBlogInfoRequest) {
        log.info("发布博客,{}", addBlogInfoRequest);
        return blogInfoService.addBlog(addBlogInfoRequest);
    }
    @PostMapping("/update")
    public boolean updateBlog(@Validated @RequestBody UpdateBlogRequest updateBlogRequest) {
        log.info("更新博客,{}", updateBlogRequest);
        return blogInfoService.updateBlog(updateBlogRequest);

    }
    @PostMapping("/delete")
    public boolean delete(@NotNull(message="博客ID不能为空") Integer blogId) {
        log.info("删除博客,ID:{}", blogId);
        return blogInfoService.delete(blogId);
    }

}
