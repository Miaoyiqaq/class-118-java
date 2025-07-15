package interface1;

public class People extends Animal implements IRun,IFly,ISwim{
    public People(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name + "在坐飞机飞行");
    }

    @Override
    public void run() {
        System.out.println(this.name + "在马拉松");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "在游泳");
    }
}
