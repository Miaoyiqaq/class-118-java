package org.example.springaopdemo.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    //目标方法
    private Object target;

    public JDKInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK中介开始代理");
        Object result = method.invoke(target, args);
        System.out.println("JDK中介结束代理");
        return result;
    }
}
