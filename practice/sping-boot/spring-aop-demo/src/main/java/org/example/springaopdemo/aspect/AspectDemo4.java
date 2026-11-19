package org.example.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectDemo4 {
    //使用@annotation来通过注解进行自定义切面--所有的MyAspect注解
    @Before("@annotation(org.example.springaopdemo.aspect.MyAspect)")
    public void doBefore() {
        log.info("Before running for AspectDemo4444");
    }

    @After("@annotation(org.example.springaopdemo.aspect.MyAspect)")
    public void doAfter() {
        log.info("After running for AspectDemo4444");
    }

}
