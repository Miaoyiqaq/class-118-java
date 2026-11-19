package org.example.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect//面向切面编程(AOP):切面类声明
@Component
public class AspectDemo {
    //捕获bookdemo目录下所有文件的所有方法
//    @Around("execution(* org.example.bookdemo.*.*.*(..))")


    //捕获controller目录下所有文件的所有方法

    //@Pointcut:统一切点--后面只需要在Around这类注解中直接添加pintCut()方法即可代表该切点
    @Pointcut("execution(* org.example.springaopdemo.controller.*.*(..))")
    //Pointcut参数解析:execution(<访问修饰符>(被省略) <返回类型> <包名.类名.方法(方法参数)> <异常>(被省略))
    public void pointCut() {}
//    //1.切点:@Around为切点表达式,在此为通知类
//    @Around("pointCut()")
//    //2.连接点:具体的某一个方法.在此为controller目录下所有的方法
//    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        //3.通知:recordTime方法中的所有逻辑为通知
//        log.info("执行Around前");
//        //执行业务逻辑代码
//        try {
//            Object proceed = joinPoint.proceed();
//            log.info("执行AfterReturning");
//            return proceed;
//        } catch (Throwable throwable) {
//            log.info("执行AfterThrowing");
//        } finally {
//            log.info("执行Around后");
//        }
//
//        return joinPoint.proceed();
//    }
//    //4.切面:切面 = 切点 + 连接点 + 通知
//
//    //@Around:环绕通知--通知方法在目标前后都被执行
//
//    //@Before:前置通知--通知方法在目标执行前执行
//    @Before("pointCut()")
//
//    public void doBefore() {
//        System.out.println("执行before");
//    }
//
//    //@After:后置通知--通知方法在目标执行后执行(目标方法异常仍然执行)
//    @After("execution(* org.example.springaopdemo.controller.*.*(..))")
//    public void doAfter() {
//        System.out.println("执行after");
//    }
//
//    //@AfterReturning:正常返回通知--通知方法在目标正常执行结束后执行(目标方法异常不执行)
//    @AfterReturning("execution(* org.example.springaopdemo.controller.*.*(..))")
//    public void doAfterReturning() {
//        System.out.println("执行AfterReturning");
//    }
//
//    //@AfterThrowing:异常返回通知--通知方法在目标异常执行结束后执行(目标方法正常结束不执行)
//    @AfterThrowing("execution(* org.example.springaopdemo.controller.*.*(..))")
//    public void doAfterThrowing() {
//        System.out.println("执行AfterThrowing");
//    }


    /***
     * 使用一个Around实现其它Before,AfterReturning...等等的所有功能
     * @param joinPoint
     * @return
     * @throws Throwable
     */
//    @Around("execution(* org.example.springaopdemo.controller.*.*(..))")
    public Object recordTime1(ProceedingJoinPoint joinPoint) throws Throwable {
        //3.通知:recordTime方法中的所有逻辑为通知
        log.info("执行Around前");
        log.info("执行doBefore前");
        //执行业务逻辑代码
        try {
            Object proceed = joinPoint.proceed();
            log.info("执行AfterReturning");
            return proceed;
        } catch (Throwable throwable) {
            log.info("执行AfterThrowing");
        } finally {
            log.info("执行after");
            log.info("执行Around后");
        }

        return joinPoint.proceed();
    }
}
