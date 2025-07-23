package demo2;

public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.setArray(123,0);
        myArray.setArray("abc",1);
        myArray.setArray(12.0f,2);

        NewMyArray<Integer> newMyArray = new NewMyArray<Integer>();//打上Integer标签
        newMyArray.setNewArray(0,123);
        newMyArray.setNewArray(1,"abc");

    }
    public static void main1(String[] args) {
        int[] array ={1,2,3,4,5,6,7,8,9};
        System.out.println(Erfenchazhao.erFenChaZhao(array,9));
    }
}
