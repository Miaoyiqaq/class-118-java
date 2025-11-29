class MyThreand extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("hallo Thread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Test {
    public static void main(String[] args) {
        MyThreand myThreand = new MyThreand();
        myThreand.start();
        System.out.println(myThreand.getState());
    }
}
