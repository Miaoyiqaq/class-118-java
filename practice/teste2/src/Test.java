

class Animal {
    //实例变量
    private String name;//使用private修饰
    private int age;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //实例方法
    public void eat() {
        System.out.println("name" + "在吃饭");
    }
    public void play() {
        System.out.println("name" + "在玩耍");
    }
}
public class Test {
    public static void main1(String[] args) {
        Animal animal1 = new Animal();

    }
}