import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void order(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public static void noOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length-1-i] = i;
        }
    }

    public static void randomOrder(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10_1000);
        }
    }

    public static void testOrder(int[] arr) {
        System.out.println("顺序数组");
        long startTime;
        long endTime;
        order(arr);
        startTime= System.currentTimeMillis();
        Sort.insertSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("插入排序耗时:" + (endTime - startTime));
        order(arr);
        startTime= System.currentTimeMillis();
        Sort.shellSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("希尔排序耗时:" + (endTime - startTime));
        order(arr);
        startTime= System.currentTimeMillis();
        Sort.selectSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("选择排序耗时:" + (endTime - startTime));
    }

    public static void testNoOrder(int[] arr) {
        System.out.println("逆序数组");
        long startTime;
        long endTime;
        noOrder(arr);
        startTime= System.currentTimeMillis();
        Sort.insertSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("插入排序耗时:" + (endTime - startTime));
        noOrder(arr);
        startTime= System.currentTimeMillis();
        Sort.shellSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("希尔排序耗时:" + (endTime - startTime));
        noOrder(arr);
        startTime= System.currentTimeMillis();
        Sort.selectSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("选择排序耗时:" + (endTime - startTime));
    }
    public static void testRandomOrder(int[] arr) {
        System.out.println("无序数组");
        long startTime;
        long endTime;
        randomOrder(arr);
        startTime= System.currentTimeMillis();
        Sort.insertSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("插入排序耗时:" + (endTime - startTime));
        randomOrder(arr);
        startTime= System.currentTimeMillis();
        Sort.shellSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("希尔排序耗时:" + (endTime - startTime));
        randomOrder(arr);
        startTime= System.currentTimeMillis();
        Sort.selectSort(arr);
        endTime= System.currentTimeMillis();
        System.out.println("选择排序耗时:" + (endTime - startTime));
    }
    public static void main2(String[] args) {
        int[] arr = new int[10];
        noOrder(arr);
        System.out.println(Arrays.toString(arr));
//        testOrder(arr);
//        testNoOrder(arr);
//        testRandomOrder(arr);
    }
    public static void main(String[] args) {
        int[] elem = {2,25,43,14,37,71};
        Sort.insertSort(elem);
        System.out.println(Arrays.toString(elem));
    }
}
