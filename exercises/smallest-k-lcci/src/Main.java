import java.util.Comparator;
import java.util.PriorityQueue;

class IntMaxCompare implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] tmp = new int[k];
        if(k <= 0 || arr == null)
            return tmp;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new IntMaxCompare());
        for (int i = 0; i < arr.length; i++) {
            if(i < k) {
                queue.offer(arr[i]);
            }
            else if(queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            tmp[i] = queue.poll();
        }
        return tmp;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}