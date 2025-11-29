public class Test6 {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            while(!Thread.currentThread().isInterrupted()) {//判断线程是否收到中断信号
                System.out.println("线程运行中");
                try {
                    Thread.sleep(500);//sleep被中断会抛出InterruptedException
                } catch (InterruptedException e) {
                    System.out.println("线程休眠时被中断,正在退出线程");
                    System.out.println("sleep被中断后线程的中断标志位是" + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();//重新标记中断信号
                }
            }
            System.out.println("线程是否被中断:" + Thread.currentThread().isInterrupted());
        });
        thread.start();
        System.out.println("main线程开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main线程结束,结束前设置中断标记位");
        thread.interrupt();
    }
}
