import java.util.Scanner;

public class Test12 {
    volatile private static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1已进入");
            while (flag) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
            System.out.println("t1已退出");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("输入来终止t1");
            Scanner scanner = new Scanner(System.in);
            scanner.next();
            flag = false;
            System.out.println("flag = " + flag);
            System.out.println("t2已退出");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}