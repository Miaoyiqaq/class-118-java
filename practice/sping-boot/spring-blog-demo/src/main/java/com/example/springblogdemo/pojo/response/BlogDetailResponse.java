package com.example.springblogdemo.pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
/***
 * 博客详情的响应数据
 */
public class BlogDetailResponse {
    private Integer id;
    private String title;
    private String content;
    private Integer deleteFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
