package interface1;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird("哪吒");
        People people = new People("蔡徐坤");
        bird.fly();
        bird.run();
        people.fly();
        people.run();
        people.swim();
    }
}
