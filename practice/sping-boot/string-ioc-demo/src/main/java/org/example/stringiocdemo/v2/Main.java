package org.example.stringiocdemo.v2;

//解耦版本,修改size时只会影响到Tire类
//ioc思想(控制反转):委托类来进行类创建,
//di思想(依赖注入):需要使用时才引入依赖.例如new Car(framework)时,需要使用framework类,此时再注入
public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(12);
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }
}
