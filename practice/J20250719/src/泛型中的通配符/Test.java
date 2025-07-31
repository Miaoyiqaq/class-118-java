package 泛型中的通配符;

class Massage<T>{
    private T massage;


    public void setMassage(T massage) {
        this.massage = massage;
    }

    public T getMassage() {
        return massage;
    }
}
class Test1{
    public static void fun(Massage<?> tmp){//若不使用通配符则Test方法中调用Test1.fun时会报错
        System.out.println(tmp.getMassage());
    }
}
public class Test {

    public static void main(String[] args) {
        Massage<Integer> massage1 = new Massage<>();
        massage1.setMassage(123);
        Test1.fun(massage1);
        Massage<String> massage = new Massage<>();
        massage.setMassage("hiiioi");
        Test1.fun(massage);
    }

}
