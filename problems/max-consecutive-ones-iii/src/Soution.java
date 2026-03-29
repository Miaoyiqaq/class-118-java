class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0,right = 0,max = 0;
        int kCount = 0;
        for (; right < nums.length; right++) {
            //进窗口
            if(nums[right] == 0) {
                kCount++;
            }
            //出窗口
            while(kCount > k) {
                if(nums[left++] == 0) {
                    kCount--;
                }
            }
                max = Math.max(max, right - left +1);
        }
        return max;
    }
}