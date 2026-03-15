import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        },1000L);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        },2000L);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        },3000L);
        System.out.println("end");
        //timer.cancel();//关闭所有进程
    }
}
