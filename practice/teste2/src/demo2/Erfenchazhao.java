package demo2;

public class Erfenchazhao {
    public static int erFenChaZhao(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < num) {
                left = mid +1;
            } else if (arr[mid] > num) {
                right = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
