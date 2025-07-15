package implements1;

public class Mouse implements IUsb{
    @Override
    public void openDevices() {
        System.out.println("连接鼠标");
    }

    public void use() {
        System.out.println("使用鼠标");
    }
    @Override
    public void closeDevices() {
        System.out.println("断开鼠标");
    }
}
