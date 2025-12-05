import java.util.Arrays;

class MyHeap {
    public int[] elem;
    private int userSize;


    public MyHeap() {
        elem = new int[10];
    }
    public void initArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            elem[i] = arr[i];
            userSize++;
        }
    }
    private void swap(int a,int b) {
        int tmp = elem[a];
        elem[a] = elem[b];
        elem[b] = tmp;
    }
    private void shiftDown(int parent, int userSize) {//将较大的元素向上转移,向上调整
        int child = parent*2 +1;//此时child是左孩子
        while(child < userSize) {
            if (child + 1 < userSize && elem[child] < elem[child +1]) {//判断左右节点大小,如果右节点大就将转变为右孩子.前提是右孩子存在
                child++;
            }
            if (elem[child] > elem[parent]) {//判断父节点和子节点大小,如果子节点大就交换值
                swap(child, parent);
                //准备进入新一轮循环,直到子节点为空(子节点序号大于总长度)
                parent = child;
                child = parent * 2 + 1;
            }
            else {//如果最大的节点都没有父节点大说明该堆已经是大根堆,不用调整了,直接跳出循环
                break;
            }
        }
    }
    private void shiftUp(int userSize) {//添加新元素时保证大根堆不变,向下调整
        int child = userSize-1;
        int parent = (child-1)/2;
        while(child != 0) {
            if(elem[child] < elem[parent]) {
                swap(child,parent);
                child = parent;
                parent = (parent-1)/2;
            }
            else break;
        }
    }
    public void createHemp() {//从倒数第二行节点开始,以该节点为父节点,不断判断与子节点的大小并进行调换
        for (int parent = (userSize -1-1) / 2; parent >= 0 ; parent--) {//最后一个根堆的父节点是userSize-1-1)/2
            shiftDown(parent,userSize);
        }
    }
    public void offer(int data) {
        if(isFull()) {//判断数组有没有满,满的话就扩容
            int[] tmpElem = new int[elem.length*2];
            for (int i = 0; i < userSize; i++) {
                tmpElem[i] = elem[i];
            }
            elem = tmpElem;
        }
        elem[userSize] = data;
        userSize++;
        shiftUp(userSize);
    }

    /***
     *获取堆顶元素
     */
    public int poll() {
        if(isEmpty()) {
            System.out.println("堆为空,无法获取节点");
            return -1;
        }
        swap(userSize -1,0);
        int data = userSize-1;
        userSize--;
        shiftDown(0,userSize);
        return data;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("堆为空");
            return -1;
        }
        return elem[0];
    }

    /***
     * 使用堆来对数组排序.O(n*logn)冒泡排序是O(n^2)
     */
    public void heapSort() {
        int end = userSize -1;
        while (end != 0) {
            swap(0,end);
            shiftDown(0,end);
            end--;
        }
    }
    public boolean isEmpty() {
        return userSize == 0;
    }
    public boolean isFull() {
        return userSize == elem.length;
    }
}

class Solution {
    public int[] smallestK(int[] arr, int k) {
        MyHeap myHeap = new MyHeap();
        int[] tmp = new int[k];
        for (int j = 0; j < arr.length;j++) {
            if(j <=k) {
                myHeap.offer(arr[j]);
            }else if (k ==0) {
                return tmp;
            }
            if(arr[j] < myHeap.peek()) {
                myHeap.poll();
                myHeap.offer(arr[j]);
            }
        }

        for (int i = k-1; i >= 0; i--) {
            tmp[i] = myHeap.poll();
        }
        return tmp;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,3,5,7,2,4,6,8};
        int k = 4;
        System.out.println(Arrays.toString(solution.smallestK(array, 4)));
    }
}

