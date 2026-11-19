package com.example.springblogdemo.pojo.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddBlogInfoRequest {
    @NotNull(message = "作者ID不能为空")
    @Min(value = 0, message = "作者ID不能小于0")
    private Integer userId; // 用户ID
    @NotBlank(message = "标题不能为空")
    private String title; // 标题
    @NotBlank(message = "内容不能为空")
    private String content; // 内容
}
