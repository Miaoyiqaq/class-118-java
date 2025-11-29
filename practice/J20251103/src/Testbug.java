class SingletonBroken {

    private static SingletonBroken instance; // 没有 volatile

    private int value;

    private SingletonBroken() {
        // 让构造稍微变慢，增大出错概率
        this.value = 100;
        try { Thread.sleep(1); } catch (Exception e) {}
    }

    public int getValue() {
        return value;
    }

    public static SingletonBroken getInstance() {
        if (instance == null) {
            synchronized (SingletonBroken.class) {
                if (instance == null) {
                    instance = new SingletonBroken(); // 有可能发生重排序
                }
            }
        }
        return instance;
    }
}

public class Testbug {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                SingletonBroken s = SingletonBroken.getInstance();
                if (s.getValue() != 100) {   // value 应该永远为 100
                    System.out.println("错误：value = " + s.getValue());
                    System.exit(0);
                }
            }).start();
        }
    }
}

