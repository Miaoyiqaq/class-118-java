class Singleton {
    private static Singleton singleton = new Singleton();
    public static Singleton getInstance(){
        return singleton;
    }
    private Singleton(){}
}


class SingletonLazy {
    private static SingletonLazy singletonLazy = null;
    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            synchronized (SingletonLazy.class) {
                if (singletonLazy == null) {
                    return singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }
    private SingletonLazy(){}
}


public class Test13 {
}
