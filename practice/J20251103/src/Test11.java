public class Test11 {
    //死锁的场景,两个线程两把锁
    private static final Object LockA = new Object();
    private static final Object LockB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LockA) {
                System.out.println("t1拿到锁A,准备拿到锁B");
                try {
                    Thread.sleep(100);//确保两个线程同时获取到锁
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LockB) {
                    System.out.println("t1拿到锁B");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (LockB) {
                System.out.println("t2拿到锁B,准备拿到锁A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LockA) {
                    System.out.println("t2拿到锁A");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
