class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, count = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        for (right = 0; right < n; right++) {
            sum += nums[right];
            while(sum >= target) {
                if(count > right - left) {
                    count = right -left +1;
                }
                sum -= nums[left++];
            }

        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,1,2,4,3};
        System.out.println(solution.minSubArrayLen(7,arr));
    }
}
