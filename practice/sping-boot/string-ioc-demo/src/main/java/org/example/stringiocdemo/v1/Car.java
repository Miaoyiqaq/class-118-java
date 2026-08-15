package org.example.stringiocdemo.v1;

public class Car {
    private Framework framework;

    public Car(int size) {
        framework = new Framework(size);
        System.out.println("Framework init");
    }
    public void run() {
        System.out.println("Running Car");
    }
}
