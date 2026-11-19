package com.example.springblogdemo.common.advice;

import com.example.springblogdemo.common.exception.BlogException;
import com.example.springblogdemo.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler
    public Result handler(BlogException e) {
        log.warn("发生异常,e:{}", e.getMessage());
        return Result.fail(e.getMessage());
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Result handler(HandlerMethodValidationException e) {
        List<String> errors = new ArrayList<>();
        e.getAllErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });
        log.warn("发生异常,参数校验失败e:{}", errors);
        return Result.fail("参数校验校验失败");
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Result handler(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getAllErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });
        log.warn("发生异常,参数校验失败e:{}", errors);
        return Result.fail("参数校验失败:" + errors);
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Result handler(HttpMessageNotReadableException e) {
        log.warn("数据解析失败/格式错误");
        return Result.fail("数据解析失败/格式错误");
    }
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler
    public Result handler(HttpRequestMethodNotSupportedException e) {
        List<String> errors = new ArrayList<>();
        log.warn("发生异常,请求方式:{}错误", e.getMethod());
        return Result.fail("请求方式错误,尝试更换请求方式");
    }


}
