package org.example.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectDemo5 {
    @Around("@annotation(org.example.springaopdemo.aspect.MyAspect)")
    public Object timeRecord(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();

        } catch (Throwable throwable) {
            log.error("发生异常");
        }
        log.info(joinPoint.getSignature() + "耗时:{}ms", System.currentTimeMillis() - start);
        return proceed;
    }
}
