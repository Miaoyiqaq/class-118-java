package demo1;

class Animal{
    String name;
    int age;

    Animal(String name,int age){
        this.name = name;
        this.age = age;
    }
    void eat(){
        System.out.println(name + "吃东西");
    }
    void sleep(){
        System.out.println(name + "在睡觉");
    }
}

class Cat extends Animal{
    Cat(String name,int age){
        super(name, age);
    }
    @Override
    void eat() {
        System.out.println(name + "吃鱼");
    }
    void sleep(){
        System.out.println(name + "猫在睡觉");
    }
}

class Dog extends Animal{
    Dog(String name, int age) {
        super(name, age);
    }

    void eat(){
        System.out.println(name + "吃骨头");
    }

    @Override
    void sleep() {
        System.out.println(name + "狗在睡觉");
    }
}

class Bird extends Animal{
    Bird(String name,int age){
        super(name, age);
    }

    @Override
    void eat() {
        System.out.println(name + "吃虫子");
    }

    @Override
    void sleep() {
        System.out.println(name + "鸟在睡觉");
    }
}

public class Test {
    public static void eat(Animal a) {
    a.eat();
    }
    public static void sleep(Animal a) {
    a.sleep();
    }
    public static void main(String[] args) {
    Cat cat = new Cat("虎头",1);
    Dog dog = new Dog("旺财",2);
    Bird bird = new Bird("啾啾",3);
    eat(cat);
    eat(dog);
    eat(bird);
    sleep(cat);
    sleep(dog);
    sleep(bird);
    }

}
