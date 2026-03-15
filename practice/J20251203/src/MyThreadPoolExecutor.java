import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolExecutor {
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();//定义一个阻塞队列
    public MyThreadPoolExecutor(int nThread) {//根据参数创建多个线程
        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread(() -> {
                while(true) {
                    Runnable runnable = null;
                    try {
                        runnable = queue.take();//如果没有使用到的线程会自动阻塞
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    runnable.run();//运行runnable内容
                }
            });
            t.start();//开始执行线程
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
    public static void main(String[] args) throws InterruptedException {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5);
        for (int i = 0; i < 1000; i++) {//假如有100个任务
            int id = i;
            myThreadPoolExecutor.submit(() -> {
                System.out.println("线程:" + Thread.currentThread().getName() + "正在执行第" + id + "个任务");
            });
        }
    }
}
