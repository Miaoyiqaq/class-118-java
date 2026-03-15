public class Sort {
    /**
     * 插入排序
     * @param arr 需要排序的数组
     */
    public static void insertSort(int[] arr) {
        int size = arr.length;//获取数组长度
        //int i = 1;//i是基准数的下标(第一次比较时i = 1)
        for(int i = 1; i < size; i++){//循环获取新的基准值,每次比较完一次基准值就进行新一轮的比较
            int date = arr[i];//获取基准数的值
            int j = i - 1;//j是有序区间的末尾.注意有序区间一直是[0,j]
            for (; j >= 0; j--) {//将基准数在有序区间中从右到左进行比较,并进行整体后移
                if (date < arr[j]) {//当有序区间中一个的数据大于基准数时,说明此时这个数据应该在基准数后面
                    arr[j + 1] = arr[j];//后移元素,给基准数腾出位置
                } else {
                    break;//由于有序区间是有序,所以当基准数大于有序区间中的最后一个元素时说明此时有序区间加上基准数仍然有序
                }
            }
            arr[j + 1] = date;//for循环结束后说明区间后移完成,将基准值插入到有序区间中正确的位置即可
        }
//        int size = arr.length;
//        for (int i = 1; i < size; i++) {//对i下标的元素进行比较
//            int tmp = arr[i];
//            int j = i-1;
//            for (; j >= 0; j--) {//循环比较i下标前面的所有元素,如果小于i就后移一位
//                if(tmp > arr[j]) {//如果i下标的元素比i-1的元素要大,说明此时i下标之前的元素全部都是有序;若判定条件是>=这个排序会变得不稳定
//                    break;//有序就跳出j元素循环
//                } else {//如果i元素小于i-1元素,说明此时i下标的元素和前面的元素不是有序
//                    arr[j+1] = arr[j];//后移元素
//                }
//            }
//            arr[j+1] = tmp;//在后移出的空位中添加i下标的元素
//        }
    }


    /***
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while(gap > 1) {
            gap /= 2;
            shell(arr,gap);
        }
    }

    private static void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0 ; j -= gap) {
                if(tmp >= arr[j]) {
                    break;
                } else {
                    arr[j + gap] = arr[j];
                }
            }
            arr[j + gap] = tmp;
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int mini = i;
            int j = i +1;
            for (; j < arr.length; j++) {
                if(arr[mini] > arr[j]) {
                    mini = j;
                }
            }
            swap(arr, mini, i);
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        createHeap(arr);
    }

    private static void createHeap(int[] arr) {
        for (int parent = (arr.length -1 -1) /2; parent >= 0 ; parent--) {
            shiftDown(arr,parent,arr.length);
        }
    }

    private static void shiftDown(int[] arr, int parent, int length) {
        int child = parent*2+1;
        while(child < length) {
            if(child+1 < length && arr[child] > arr[child+1]) {
                child++;
            }
            if(arr[child] < arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = parent/2 +1;
            } else {
                break;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
