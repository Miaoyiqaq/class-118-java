package demo;

import java.util.Arrays;
import java.util.Locale;

public class Test {
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        int c = 10;
        //对于基本类型变量,==比较两个变量中存储的值是否相同
        System.out.println(a == b); //false
        System.out.println(a==c);   //true
        //对于引用类型变量,==比较两个引用变量引用的是否为同一个对象
        String s1 = new String("hallo");
        String s2 = new String("hallo");
        String s3 = new String("world");
        String s4 = s1;
        System.out.println(s1==s2); //false
        System.out.println(s3==s2); //false
        System.out.println(s1==s4); //true
        //equals比较:String对象中的逐个字符
        //虽然是s1与s2引用的不是同一个对象,但是两个对象中放置的内容相同,因此输出true
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//false
    }
        //compareTo方法
        // 与equals不同的是，equals返回的是boolean类型，⽽compareTo返回的是int类型。具体⽐较⽅式：�
        //1. 先按照字典次序⼤⼩⽐较，如果出现不等的字符，直接返回这两个字符的⼤⼩差值
        //2. 如果前k个字符相等(k为两个字符⻓度最⼩值)，返回值两个字符串⻓度差值�
    public static void main2(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("ac");
        String s3 = new String("abc");
        String s4 = new String("abcdef");
        String s5 = new String("bc");
        String s6 = new String("ABC");
        System.out.println(s1.compareTo(s2));//-1
        System.out.println(s1.compareTo(s3));//0
        System.out.println(s1.compareTo(s4));//-3
        System.out.println(s4.compareTo(s1));//3
        System.out.println(s4.compareTo(s5));//-1
        //compareToIgnoreCase方法
        //与compareTo相同,但是忽略大小写比较
        System.out.println(s1.compareToIgnoreCase(s6));//0
    }
    //字符串查找
    public static void main3(String[] args) {
        String s = "aaabbbcccaaabbbccc";
        //char charAt(int index)
        //返回 index位置上字符，
        //如果 index为负数或者越界，抛出IndexOutOfBoundsExcetion异常
        System.out.println(s.charAt(3));//b     字符串中下标为3的字符是b
        //int indexOf(int ch)
        //返回ch第一次出现的位置,没有则返回-1
        System.out.println(s.indexOf('c'));//6
        System.out.println(s.indexOf('d'));//-1
        //int indexOf(int ch,int fromlndex)
        //从 fromindex 位置开始找ch第一次出现的位置，没有返回-1
        System.out.println(s.indexOf('a',3));//9
        //int lastIndexOf(int ch)
        //后往前找,返回ch第一次出现的位置，没有返回-1
        System.out.println(s.lastIndexOf('a'));//11
    }
    //转换
    public static void main4(String[] args) {
        //valueOf
        //转字符串
        String s1 = String.valueOf(1234);
        String s2 = String.valueOf(12.34);
        String s3 = String.valueOf(true);
        String s4 = String.valueOf(new Student("Xiaoming",18));
        System.out.println(s4);
        //Integer.parseInt,将字符串转整形
        //Double.parseDouble,将字符串转双浮点型
        int data1 = Integer.parseInt("1234");
        Double data2 = Double.parseDouble("12.34");
        System.out.println(data1);
        System.out.println(data2);
    }
    //大小写转换
    //toUpperCase()小写转大写
    //toLowerCase()大写转小写
    public static void main5(String[] args) {
        String S = "HELLO";
        String s = "hello";
        System.out.println(S.toLowerCase());//hello
        System.out.println(s.toUpperCase());//HELLO
    }
    //字符串转数组
    //toCharArray()
    public static void main6(String[] args) {
        String s = "asdfghjk";
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
        System.out.print(ch[i] + " ");//a s d f g h j k
        //数组转字符串
        }
        String ss = new String(ch);
            System.out.println(ss);//asdfghjk
    }
    //格式化
    public static void main7(String[] args) {
        String s = String.format("%d-%d-%d",2019,9,14);
        System.out.println(s);//2019-9-14
    }
    //字符串替换
    //String replaceAll(String regex,String replacement)替换所有类容
    //String replaceFirst(String regex,String replacement)替换第一个内容
    public static void main8(String[] args) {
        String s = "halloword";
        System.out.println(s.replaceAll("l","-"));//ha--ow
        System.out.println(s.replaceFirst("l","-"));//ha-low
        //注意事项:由于字符串是不可变对象,替换不修改当前字符串,⽽是产⽣⼀个新的字符串.
    }
    //字符串拆分
    //String[] split(String regex)将字符串全部拆分
    //String[] split(String regex,int limit)将字符串以指定格式拆分limit组
    public static void main9(String[] args) {
        String str = "hallo-word-iam-coming";
        String[] s = str.split("-");
        for (String ss : s ) {
            System.out.print(ss);//hallowordiamcoming
        }
        System.out.println();
        String[] s1 = str.split("-",2);
        for (String ss1 : s1 ) {
            System.out.print(ss1);//halloword-iam-coming
        }
        System.out.println();
        //多次拆分
        String Str = "name=zhangsan&age=18";
        String[] arr = Str.split("&");
        String arr1 = "";
        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split("=");
        System.out.println(arr2[0] + arr2[1]);
        }
    }
    //字符串截取
    //String substring
    public static void main10(String[] args) {
        String s = "helloword";
        System.out.println(s.substring(5));
        System.out.println(s.substring(0,5));
    }
    //索引从0开始
    //substring(0,5)为左闭右开

    //StringBuilder&StringBuffer
    //StringBuilder性能更好
    //StringBuffer安全性更好
}
