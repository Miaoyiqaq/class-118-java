package interface1;

public class Bird extends Animal implements IRun,IFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name + "用翅膀飞");
    }

    @Override
    public void run() {
        System.out.println(this.name + "用翅膀跑");

    }
}
