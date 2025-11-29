public class Test7 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    synchronized(lock) {
                        count++;
                    }
                }
            }
        };
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(count);
    }
}
