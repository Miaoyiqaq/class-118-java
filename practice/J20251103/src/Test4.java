class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        while (true) {
            System.out.print(Thread.currentThread().getName() + ":");
            System.out.println("hallo Thread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    };

    public static void main(String[] args) {
        MyThread myThread = new MyThread("这是MyThread线程");
        myThread.start();
    }
}
public class Test4 {

    public static void main3(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.print(Thread.currentThread().getName() + ":");
                    System.out.println("hallo Thread");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t = new Thread(runnable, "这是Thread进程");
        t.start();
    }
    public static void main2(String[] args) {
        new Thread(() -> {
            while (true){
                System.out.println("hallo thread");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public static void main1(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println("hallo thread");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
