package demo1;

import java.util.Stack;

public class Student {
    String name = "姓名";
    int age = 18;

//    public Student(String name,int age, String classRoom){
//        this.name = name;
//        this.age = age;
//        this.classRoom = classRoom;
//    }
    void eat() {
        System.out.println(this.name + "在吃饭");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
