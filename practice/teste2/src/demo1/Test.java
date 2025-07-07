package demo1;

 class Student {
    private String name;
    private int age;
    public static String classroom = "软件工程2401班";

     public static String getClassroom() {
         return classroom;
     }
 }
public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student();
        System.out.println(Student.getClassroom());
    }
}
