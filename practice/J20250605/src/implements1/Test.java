package implements1;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        KeyBoard keyBoard = new KeyBoard();
        Mouse mouse = new Mouse();
        computer.usbDevices(keyBoard);
        computer.usbDevices(mouse);

    }
}
