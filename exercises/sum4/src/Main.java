import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> num = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int a = 0;
        long data = 0;
        long t = target;
        while (a <= n -4) {
            int b = a +1;
            while (b <= n -3) {
                int left = b +1;
                int right = n -1;
                while (left < right) {
                    data = (long)nums[a]+nums[b]+nums[left]+nums[right];
                    if(data > t) {
                        right--;
                    } else if (data < t) {
                        left++;
                    } else if (data == t) {
                        num.add(new ArrayList<>(Arrays.asList(nums[a],nums[b],nums[left],nums[right])));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right +1]) {
                            right--;
                        }
                    }
                }
                b++;
                while(b < left && nums[b] == nums[b -1]) {
                    b++;
                }
            }
            a++;
            while(a < b && nums[a] == nums[a -1]) {
                a++;
            }
        }
        return num;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000},-294967296));
    }
}
