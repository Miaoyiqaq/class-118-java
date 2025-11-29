import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int max = nums.length -1;
        int count = 0;
        while (max >= 2) {
            int left = 0;
            int right = max -1;
            while (left < right) {
                if(nums[left] + nums[right] > nums[max]) {
                    count += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
            max--;
        }
        return count;
    }
}

public class Java {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4 ,2 ,3, 4};
        System.out.println(solution.triangleNumber(arr));
    }
}
