public class Test5 {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            while (true){
                System.out.println("MyThread正在运行");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"MyThread");
        System.out.print("线程状态:" + thread.getState());
        System.out.println("是否存活:" + thread.isAlive());
        thread.start();
        System.out.print("线程状态:" + thread.getState());
        System.out.println("是否存活:" + thread.isAlive());
    }
}
