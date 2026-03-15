import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            int id = i;
            service.submit(() -> {
                System.out.println("hallo" + id + Thread.currentThread().getName());
            });
        }
    }
    public static void main1(String[] args) {
        //创建固定(10)数量的线程池
        Executors.newFixedThreadPool(10);
        //创建无数量限制的线程池
        Executors.newCachedThreadPool();
        //创建一个只包含一个线程的线程池
        Executors.newSingleThreadExecutor();
        //创建一个带有定时器的线程池
        Executors.newScheduledThreadPool(10);
    }
}
