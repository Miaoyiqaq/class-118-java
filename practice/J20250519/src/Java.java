import java.util.Arrays;
import java.util.Scanner;

public class Java {
    //存在连续三个奇数的数组
    public static boolean find(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] %2 == 1){
                count++;
            }else{
                count = 0;
            }
            if(count == 3)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,2,7,9};
        System.out.println(find(arr));
    }
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    public static void sort(int[] array){
        for (int j = 0; j < array.length -1; j++) {
        for (int i = 0; i < array.length - 1 -j; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        }
    }
    public static void main7(String[] args) {
        int[] arr = new int[]{3, 3, 3, 3, 2, 2};
        sort(arr);
        int aaa = arr[arr.length/2];
        System.out.println(aaa);

        //Arrays.sort(arr);//对数组进行排序

    }
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static void main6(String[] args) {
        int[] arr = new int[]{1, 1, 4, 4, 2, 2, 3};
        int num = 0;
        for(int array : arr){
            num ^= array;
        }
        System.out.println(num);
    }

    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //你可以按任意顺序返回答案。
    //示例 1：
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        System.out.print("nums = ");
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean end = false;
        System.out.print("target = ");
        int target = scanner.nextInt();
        for (int i = 0; i < 5; i++) {
            if(end){
                break;
            }
            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        System.out.println("[" + i + "," + j + "]");
                        end = true;
                        break;
                    }
                }
            }
        }
        if (!end) {
            System.out.println("没找到");
        }
    }
    //冒泡排序
    public static void main4(String[] args) {
        int[] array = new int[]{3, 6, 7, 8, 4, 1, 2};
        for (int n = 0; n < array.length -1; n++) {
            for (int j = 0; j < array.length -1 -n; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j +1];
                    array[j +1] = tmp;
                }
            }
        }
        String arr = Arrays.toString(array);
        System.out.println(arr);
    }


    //二分查找
    public static void main3(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        while(left <= right) {
            mid = (left + right) / 2;
            if (input > array[mid]) {
                left = mid + 1;
                continue;
            }
            if (input < array[mid]) {
                right = mid - 1;
                continue;
            }
            if (input == array[mid]) {
                System.out.println("找到了下标是" + mid);
                break;
            }
        }
        if (left > right) {
            System.out.println("找不到");
        }

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
