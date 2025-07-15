package abstract1;

public class Fish extends Amail{

    public Fish(String name){
        super(name);
    }
    @Override
    void eat() {
        System.out.println(this.name + "吃鱼食");
    }
}
