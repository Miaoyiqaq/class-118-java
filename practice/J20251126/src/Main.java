public class Main {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread t1 = new Thread(() -> {//生产者
            for (int i = 0; i < 500; i++) {
                queue.put(i);
                System.out.println("生产元素" +
                        i);
            }
        });
        Thread t2 = new Thread(()-> {//消费者
            for (int i = 0; i < 500; i++) {
                System.out.println("消费元素" +
                        queue.take());
            }
        });
        t1.start();
        t2.start();
    }
}
