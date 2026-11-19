package com.example.springblogdemo.pojo.response;

import com.example.springblogdemo.common.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String errorMessage;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }
    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setErrorMessage(message);
        return result;
    }
    public static <T> Result<T> unlogin() {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.UNLOGIN.getCode());
        result.setErrorMessage("用户未登录");
        return result;
    }
}
