package com.example.springblogdemo.common.exception;

import com.example.springblogdemo.common.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class BlogException extends RuntimeException {
    private Integer code;
    private String message;
    public BlogException(String message) {
        this.code = ResultCodeEnum.FAIL.getCode();
        this.message = message;
    }
    public BlogException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
