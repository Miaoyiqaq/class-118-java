package org.example.springaopdemo.proxy;

/***
 * 代理对象
 */
public class HouseProxy implements HouseSubject {
    private HouseSubject subject;

    public HouseProxy(HouseSubject subject) {
        this.subject = subject;
    }

    @Override
    public void rentHouse() {
        System.out.println("中介代理");
        subject.rentHouse();
        System.out.println("中介代理结束");
    }

    @Override
    public void saleHouse() {
        System.out.println("中介代理");
        subject.saleHouse();
        System.out.println("中介代理结束");
    }
}
