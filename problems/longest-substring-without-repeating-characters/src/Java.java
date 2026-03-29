public class Java {
    static class Solution {
        public int lengthOfLongestSubstring(String ss) {
            char[] s = ss.toCharArray();
            int[] hash = new int[128];
            int left = 0,right = 0,max = 0;
            for (right = 0; right < ss.length(); right++) {
                //进入窗口
                hash[s[right]]++;
                //判断
                //出窗口
                while (hash[s[right]] > 1) {
                    hash[s[left++]]--;

                }
                max = Math.max(max,right -left +1);
            }
            return max;
        }
    }
}
