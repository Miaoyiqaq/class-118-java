package org.example.springaopdemo.proxy;

public class Main {
    public static void main(String[] args) {
        HouseProxy houseProxy = new HouseProxy(new RealHouseSubject());
        houseProxy.rentHouse();
    }
}
