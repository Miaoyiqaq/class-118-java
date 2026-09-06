package org.example.bookdemo.model;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static Result unLogin(){
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN.getCode());
        result.setMessage("用户未登录");
        return result;
    }

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage("");
        result.setData(data);
        return result;
    }
    public static <T> Result fail(String message, T data) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static <T> Result fail(String message) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(message);
        return result;
    }

}
