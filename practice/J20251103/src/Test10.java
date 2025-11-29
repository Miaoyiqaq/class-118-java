public class Test10 {
    public synchronized void testA() {
        System.out.println("testA" + "已进入");
        testB();
    }
    public void testB() {
        System.out.println("testB" + "已进入");
    }
    public static void main(String[] args) {
        Test10 t = new Test10();
        t.testA();
    }
}
