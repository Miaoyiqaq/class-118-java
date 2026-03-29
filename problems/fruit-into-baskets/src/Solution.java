import java.util.HashMap;

class Solution {

    /***
     * 滑动窗口加自建哈希表(极致优化)
     */
    public int totalFruit1(int[] fruits) {
        int left = 0, right = 0, max = 0;
        int[] hash = new int[fruits.length];
        int kinds = 0;
        for (; right < fruits.length; right++) {
            //进入窗口
            if(hash[fruits[right]] == 0) {//判断是否为新种类
                kinds++;
            }
            hash[fruits[right]]++;

            //出窗口
            while (kinds > 2) {
                if(hash[fruits[left++]]-- == 1) {//判断移除后是否少一个种类
                    kinds--;
                }
            }
            max = Math.max(max, right - left +1);
        }
        return max;
    }
    /***
     * 滑动窗口加哈希表
     */
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (; right < fruits.length; right++) {
            //进入窗口
            hashMap.put(fruits[right], hashMap.getOrDefault(fruits[right],0) +1);
            //出窗口
            while (hashMap.size() > 2) {
                hashMap.put(fruits[left], hashMap.getOrDefault(fruits[left],0) -1);
                if(hashMap.get(fruits[left]) == 0) {
                    hashMap.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}