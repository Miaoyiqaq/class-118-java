package org.example.springaopdemo.proxy;

import org.aopalliance.intercept.MethodInvocation;
import org.jspecify.annotations.Nullable;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {
    //目标对象
    private Object target;
    public CglibInterceptor(Object target) {
        this.target = target;
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //代理增强
        System.out.println("CGlib代理");
        //放射调用被代理对象
        Object result = method.invoke(target, args);
        System.out.println("CGlib结束代理");
        return result;
    }
}
