package demo2;
class Big{
    int a = 1;
    void test(){
        System.out.println("调用了父类的方法");
    }
}
class Small extends Big{
    int a = 2;
    int b = 3;
    void print(){
        System.out.println("子类的a:" + a);
        System.out.println("父类的a:" + super.a);
    }
    void test(){
        System.out.println("调用了子类的方法");
        super.test();
    }
}
public class Test {
    public static void main(String[] args) {
       Small sma = new Small();
       sma.print();
       sma.test();
    }
}
