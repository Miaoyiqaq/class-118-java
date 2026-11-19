package org.example.springaopdemo.proxy;

/***
 * 被代理对象
 */
public class RealHouseSubject implements HouseSubject {
    @Override
    public void rentHouse() {
        System.out.println("房东出租房子");
    }

    @Override
    public void saleHouse() {
        System.out.println("房东出售房子");
    }
}
