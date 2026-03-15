import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private final int[] elem;
    private int head = 0;
    private int tail = 0;
    private int size;
    public MyBlockingQueue() {
        this(10);
    }

    /***
     * 可以手动指定要创建的数组大小
     * @param length 数组大小
     */
    public MyBlockingQueue(int length) {
        elem = new int[length];
    }
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void put(int data) {
        lock.lock();
        try {
            while(size == elem.length) {
                notFull.await();
            }
            elem[tail++] = data;
            if(tail == elem.length) {
                tail = 0;
            }
            size++;
            notEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        lock.lock();
        try {
            while(size == 0) {
                notEmpty.await();
            }
            int tmp = elem[head++];
            if(head == elem.length) {
                head = 0;
            }
            size--;
            notFull.signal();
            return tmp;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
