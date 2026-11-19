package org.example.bookdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect//面向切面编程(AOP)
@Component
public class TimeAspect {
    //捕获bookdemo目录下所有文件的所有方法
//    @Around("execution(* org.example.bookdemo.*.*.*(..))")


    //捕获controller目录下所有文件的所有方法


    //1.切点:@Around为切点表达式,在此为通知类
    @Around("execution(* org.example.bookdemo.controller.*.*(..))")
    //2.连接点:具体的某一个方法.在此为controller目录下所有的方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //3.通知:recordTime方法中的所有逻辑为通知
        long start = System.currentTimeMillis();
        //执行业务逻辑代码
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法耗时:{}ms", end - start);
        return proceed;
    }
    //4.切面:切面 = 切点 + 连接点 + 通知
    //即
}
