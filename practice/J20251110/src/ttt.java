import java.util.Arrays;

class Solution {
    public void duplicateZeros(int[] arr) {
        int left = 0;
        int right = -1;
        while(left < arr.length) {
            if(arr[left] == 0 ) {
                right++;
            }
            right++;
            if(right >= arr.length -1){
                break;
            }
            left++;
        }
        if(right == arr.length) {
            arr[arr.length-1] = 0;
            left--;
            right -=2;
        }
        while (left >= 0) {
            if(arr[left] == 0){
                arr[right] = 0;
                right--;
                arr[right] = 0;
                right--;
            }
            else {
               arr[right] = arr[left];
                right--;
            }
            left--;
        }
    }
}
public class ttt {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //int[] nums = {1,0,2,3,0,4,5,0};
        Solution solution = new Solution();
        solution.duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
