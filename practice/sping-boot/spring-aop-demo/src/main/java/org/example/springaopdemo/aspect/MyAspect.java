package org.example.springaopdemo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//自定义注解必要的注解
@Target({ElementType.TYPE, ElementType.METHOD})//申明可作用域
@Retention(RetentionPolicy.RUNTIME)//申明生命周期

public @interface MyAspect {
}
