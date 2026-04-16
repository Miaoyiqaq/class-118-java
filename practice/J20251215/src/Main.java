import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("模拟系统启动");
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("正在启动磁盘检查");
                Thread.sleep(2000);
                System.out.println("磁盘检查完毕");
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("正在启动内存检查");
                Thread.sleep(3000);
                System.out.println("内存检查完毕");
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("正在启动主板检查");
                Thread.sleep(1000);
                System.out.println("主板检查完毕");
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("等待系统自检完毕");
        countDownLatch.await();
        System.out.println("所有自检完毕,进入系统");
    }
    public static void main2(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                semaphore.release();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                semaphore.release();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
    public static void main1(String[] args) throws InterruptedException {
       Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        System.out.println("拿到一个资源");
        semaphore.acquire();
        System.out.println("拿到一个资源");
        System.out.println("尝试拿到一个资源:" + semaphore.tryAcquire());
        semaphore.release();
        System.out.println("释放一个资源");
    }
}