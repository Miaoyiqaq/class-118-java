package org.example.stringiocdemo.facade;

public class FacadeMain {
    public static void main(String[] args) {
        FacadeLight facadeLight = new FacadeLight();
        facadeLight.on();
        facadeLight.off();
    }
}
