import org.w3c.dom.ls.LSOutput;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n -1;
        int volume = 0;
        int tmp;
        while (left <= right) {
            tmp = (right - left) * (height[left] > height[right] ? height[right] : height[left]);
            volume = Math.max(volume,tmp);
            if(height[left] >= height[right]) {
                right--;
            }
            else
            left++;
        }
        return volume;
    }
}
public class Java {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(test));
    }

}
