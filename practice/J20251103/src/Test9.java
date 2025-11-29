class Counter {
    private int count = 0;
    synchronized public void add() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
public class Test9 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                    counter.add();
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                    counter.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }
}
