package com.example.springblogdemo.pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
/***
 * 博客列表的响应数据
 */
public class BlogInfoResponse {
    private Integer id;
    private String title;
    private String content;//简介
    private Integer userId;
    private Integer deleteFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /***
     * 只提取文章前50字作为简介
     * @return
     */
    public String getContent() {
        if(!StringUtils.hasText(content)) {
            return "";
        }
        //删除首行'#'号
        String plainContent = content.replaceAll("(?m)^\\s*#+\\s*", "");
        if(plainContent.length() > 50) {
            return plainContent.substring(0, 50) + "...";
        } else {
            return plainContent;
        }
    }
}
