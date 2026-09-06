package org.example.bookdemo.advice;

import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
@ResponseBody
public class ErrorAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        log.error("异常捕获:" + e.getMessage());
        return Result.fail(e.getMessage(), "发生未知异常");
    }

    @ExceptionHandler
    public Result exceptionHandler (NoResourceFoundException e){
        log.error("异常捕获：" + e.getMessage());
        return Result.fail(e.getMessage(), "文件不存在:" + e.getResourcePath());
    }
//    @ExceptionHandler
//    public Result handler(ArithmeticException e){
//        return Result.fail(e.getMessage(), "发生算术异常");
//    }
//
//    @ExceptionHandler
//    public Result handler(ArrayIndexOutOfBoundsException e){
//        return Result.fail(e.getMessage(), "发生数组越界异常");
//    }
//    @ExceptionHandler
//    public Result handler(NullPointerException e){
//        return Result.fail(e.getMessage(), "发生空指针异常");
//    }
}
