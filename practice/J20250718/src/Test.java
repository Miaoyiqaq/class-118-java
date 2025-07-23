import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int[] num = new int[nums.length];
        k = k % num.length;
        while (k-- != 0) {
        int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 < nums.length) {
                    num[i + 1] = nums[i];
                } else {
                    num[j] = nums[i];
                    j++;
                }
            }
            for (int l = 0; l < nums.length; l++) {
                nums[l] = num[l];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(7%5);
}
    public int missingNumber(int[] nums) {
        /*这是一个代码更简单的方法 异或法.具体如下 */
        int tmp = nums.length;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= i;
            tmp ^= nums[i];
        }
        return tmp;
            }
        public int missingNumber1(int[] nums) {
        // 如果说 一个连续数组中缺少了某一个数字
            // 我第一时间想到的是用零一的方法来做
            // 具体 行为如下首先对这个数组进行排序
            // 然后将数组中每一个元素%2放入另一个数组中
            // 这个时候我们就得到了010101的有序数组
            // 但是他肯定不会一直是有序的
            // 因为缺少了某一个元素所以里面会有一段是连续两个零或连续两个一的
            // 这个时候我们只需要判断连续两个零或两个一出现的位置即可知道是哪个地方的元素消失了
            int[] num = new int[nums.length];//创建一个新数组用来存储01
            Arrays.sort(nums);//对原始数组进行排序
            for (int i = 0; i < nums.length; i++) {//将排序后的每个数组元素%二并放入新数组中
                num[i] = nums[i] % 2;
            }
            if (num[0] == 1) {//判断一个特殊条件
                return 0;
            }
            for (int i = 0; i < nums.length - 1; i++) {//对比连续的零或一存在的位置
                if (num[i] == num[i + 1]) {
                    return i + 1;
                }
            }
            return nums.length;//如果没有对比到则说明消失的数字是数组的最后一个
        }
    }

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
    int[] arr = new int[] {1,2,3,4,5};
    solution.rotate(arr,7);
    }
}

