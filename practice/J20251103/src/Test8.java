public class Test8 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock){
                    count++;
                }
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock2) {
                    count++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
