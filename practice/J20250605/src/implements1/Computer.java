package implements1;


public class Computer {


    public void usbDevices(IUsb usb) {
        usb.openDevices();
        if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.using();
        } else if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.use();
        }
        usb.closeDevices();
    }
}
