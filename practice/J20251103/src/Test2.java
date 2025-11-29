public class Test2 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                while(true){
                    System.out.println("hallo Thread");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();
    }
}
