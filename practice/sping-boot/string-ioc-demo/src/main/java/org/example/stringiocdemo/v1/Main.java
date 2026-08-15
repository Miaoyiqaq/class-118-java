package org.example.stringiocdemo.v1;
//初始版本.修改size时需要影响到Framework,Car,Bottom,Tire类
public class Main {
    public static void main(String[] args) {
        Car car = new Car(18);
        Car car1 = new Car(18);

        car.run();
        car1.run();
    }
}
