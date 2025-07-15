package abstract1;

public class Dog extends Amail{

    public Dog(String name){
        super(name);
    }
    @Override
    void eat() {
        System.out.println(this.name + "吃狗粮");
    }
}
