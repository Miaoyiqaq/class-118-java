package org.example.springaopdemo.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class DynamicMain {
    public static void main(String[] args) {
        //CGlib动态创建代理类
        HouseSubject target = new RealHouseSubject();
        HouseSubject houseSubject = (HouseSubject) Enhancer.create(target.getClass(), new CglibInterceptor(target));
        houseSubject.rentHouse();
    }
    public static void main1(String[] args) {
        //被代理对象
        HouseSubject target = new RealHouseSubject();
        //动态创建代理类
        HouseSubject houseProxy = (HouseSubject) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{HouseSubject.class}, new JDKInvocationHandler(target));
        houseProxy.rentHouse();
    }
}
