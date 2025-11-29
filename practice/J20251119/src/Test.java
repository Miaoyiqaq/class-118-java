import java.util.Scanner;

public class Test {
        private static boolean flag = true;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1已结束");
        });

        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            flag = false;
        });
        t1.start();
        t2.start();
    }
}
