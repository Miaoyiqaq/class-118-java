import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable runnable;//要执行的任务
    private long time;//执行时间

    public long getTime() {
        return time;
    }
    public void run() {
        runnable.run();
    }
    public MyTimerTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }
}
public class MyTimer {
    Lock locker = new ReentrantLock();
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    public MyTimer() {
        Thread t = new Thread(()-> {
            try {
                while (true) {
                    synchronized (locker) {
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        long currentTime = System.currentTimeMillis();//系统时间
                        if (task.getTime() <= currentTime) {//判断时间
                            task.run();
                            queue.poll();
                        } else {
                            //超时等待
                            locker.wait(task.getTime() - currentTime);
                        }
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
    public void schedule(Runnable task, Long delay) {
        synchronized (locker) {
            queue.offer(new MyTimerTask(task, delay));
            locker.notify();
        }
    }
}
