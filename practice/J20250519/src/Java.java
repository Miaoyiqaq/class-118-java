import java.util.Arrays;

public class Java {
    //二分查找
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    //
    //如数组：[1,2,3,4,5,6]
    //
    //调整后可能是：[1, 5, 3, 4, 2, 6]
    public static void main2(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 8, 9};
        int[] tmp = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (tmp[i] % 2 != 0) {
                array[j] = tmp[i];
                j++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (tmp[i] % 2 == 0) {
                array[j] = tmp[i];
                j++;
            }
        }String aaa = Arrays.toString(array);
        System.out.println(aaa);
    }
    public static void transform(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = 2*array[i];
        }
    }
    public static void main1(String[] args) {
        //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
        // 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
        int arr[] = new int[]{2,4,8};
        transform(arr);
        String abc = Arrays.toString(arr);
        System.out.println(abc);
    }
}
