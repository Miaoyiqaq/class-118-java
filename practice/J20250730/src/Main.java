import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        MyHeap myHeap = new MyHeap();
        //myHeap.initArray(array);
        //myHeap.createHemp();
        for (int i = 0; i < array.length; i++) {
            myHeap.offer(array[i]);
        }
        System.out.println(Arrays.toString(myHeap.elem));
        //myHeap.offer(80);
        System.out.println(Arrays.toString(myHeap.elem));
        System.out.println(myHeap.poll());
        myHeap.heapSort();
        System.out.println(Arrays.toString(myHeap.elem));
    }
}
