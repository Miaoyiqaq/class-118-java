import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {-1,-1};
        }
        int[] index = new int[2];
        //找到左端点
        int left = 0, right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) {
                right = mid;
            }
            if(nums[mid] < target) {
                left = mid +1;
            }

        }
        if(left == right) {
            if(nums[left] == target) {
                index[0] = left;
            }else {
                return new int[]{-1,-1};
            }
        }
        //找到右端点
        left = 0;
        right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left +1)/2;
            if(nums[mid] > target) {
                right = mid -1;
            }
            if(nums[mid] <= target) {
                left = mid;
            }
            if(left == right) {
                index[1] = left;
            }
        }
        return index;
    }
}