
class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0,right = 0,tagger = 0,sum = 0,length = 0;
        boolean flag = false;
        for (int num : nums) {
            tagger += num;
        }
        tagger -= x;
        if(tagger < 0) {
            return -1;
        }
        for (; right < nums.length; right++) {
            //进入窗口
            sum += nums[right];
            //出窗口
            while (sum > tagger) {
                sum -= nums[left++];
            }
            if (sum == tagger) {
                flag = true;
                length = Math.max(length, right - left + 1);
            }
        }
        if(!flag) {
            return -1;
        }
        return nums.length - length;
    }
}