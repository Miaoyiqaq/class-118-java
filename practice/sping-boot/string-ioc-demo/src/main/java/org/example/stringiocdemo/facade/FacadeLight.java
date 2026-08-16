package org.example.stringiocdemo.facade;

public class FacadeLight {
    LivingRoomLight livingRoomLight = new LivingRoomLight();
    BadRoomLight badRoomLight = new BadRoomLight();

    public void off() {
        livingRoomLight.off();
        badRoomLight.off();
    }
    public void on() {
        livingRoomLight.on();
        badRoomLight.on();
    }
}
