package implements1;

public class KeyBoard implements IUsb{
    @Override
    public void openDevices() {
        System.out.println("连接键盘");
    }
    public void using() {
        System.out.println("使用键盘");
    }
    @Override
    public void closeDevices() {
        System.out.println("断开键盘");
    }
}
