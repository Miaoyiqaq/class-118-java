import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(nums);
        int cur = 0;
        int n = nums.length;
        while(cur <= n -1 -2 && nums[cur] <= 0){//判断有效数组并记录
            //-2是因为有两个指针,-1是数组最后一个元素
            int left = cur +1;
            int right = n-1;
            while(left < right) {
                if(nums[cur] + nums[left] +nums[right] > 0) {
                    right--;
                } else if (nums[cur] + nums[left] +nums[right] < 0) {
                    left++;
                }else if (nums[cur] + nums[left] +nums[right] == 0) {//记录数组
                    arrayList.add(new ArrayList<Integer>(Arrays.asList(nums[cur], nums[left], nums[right])));

                    right--;
                    left++;
                    while (left < right && nums[right] == nums[right + 1]) {//去重
                        right--;
                    }
                    while (left < right && nums[left] == nums[left - 1]) {//去重
                        left++;
                    }
                }
            }
            cur++;
            while (cur < n && nums[cur] == nums[cur -1]) {//去重
                cur++;
            }
        }
        return arrayList;
    }
}
public class Java {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(arr));;
    }
}
