package org.example.stringiocdemo.facade;

public class LivingRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("开客厅灯");
    }

    @Override
    public void off() {
        System.out.println("关客厅灯");
    }
}
