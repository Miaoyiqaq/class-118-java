package org.example.stringiocdemo.v2;

public class Car {
    private Framework framework;
    public Car(Framework framework) {
        this.framework = framework;
        System.out.println("Framework created");
    }

    public void run() {
        System.out.println("car running");
    }
}
