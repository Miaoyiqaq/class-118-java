import java.time.Instant;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
        Random random = new Random();
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1,101);
        }
        //实现代码, 能够创建两个线程, 对这个数组的所有元素求和.

        //其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
        AtomicInteger count1 = new AtomicInteger();
        Thread  t1 = new Thread(() -> {
            Instant start = Instant.now();
            for (int i = 0; i < arr.length; i += 2) {
                count1.addAndGet(arr[i]);
            }
            Instant end = Instant.now();
            long duration = end.toEpochMilli() - start.toEpochMilli();
            System.out.println("线程1运行时间:" + duration);
        });
        AtomicInteger count2 = new AtomicInteger();
        Thread  t2 = new Thread(() -> {
            Instant start = Instant.now();
            for (int i = 1; i < arr.length; i += 2) {
                count2.addAndGet(arr[i]);
            }
            Instant end = Instant.now();
            long duration = end.toEpochMilli() - start.toEpochMilli();
            System.out.println("线程2运行时间:" + duration);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //最终再汇总两个和, 进行相加
        count = count1.get() + count2.get();
        System.out.println(count);
        //记录程序的执行时间.
    }
    public static void main6(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread A = new Thread(() -> {
                System.out.print("A");
            });
            Thread B = new Thread(() -> {
                System.out.print("B");
            });
            Thread C = new Thread(() -> {
                System.out.print("C");
            });
            A.start();
            A.join();
            B.start();
            B.join();
            C.start();
            C.join();
            System.out.println();
        }
    }
    public static void main5(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        });
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        });
        t1.setName("a");
        t2.setName("b");
        t3.setName("c");
        t1.start();
        t2.start();
        t3.start();
    }
    public static void main3(String[] args) throws InterruptedException {
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