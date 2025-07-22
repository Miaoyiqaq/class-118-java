package demo2;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        int right = arr.length;
        for (int i = 0; i < right - 1; i++) {//不能使用right--,这会导致在运行right值不断减小
            for (int j = 0; j < right - i - 1; j++) {//由于arr[j+1]的纯在,当j=right时,arr[j+1]会发生数组越界,所以应right-1
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
