package 重写ArrayList;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.SeqList();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(4 ,5);
        myArray.remove(2);
        //myArray.set(5,10);
        //System.out.println(myArray.get(1));
        //System.out.println(myArray.get(5));
        //System.out.println(Arrays.toString(myArray.indexOf(1)));
        //System.out.println(myArray.contains(7));
        System.out.println(Arrays.toString(myArray.elem));
        System.out.println(myArray.usedSize);
        myArray.clear();
        System.out.println(Arrays.toString(myArray.elem));
        System.out.println(myArray.usedSize);
        myArray.display();
    }
}
