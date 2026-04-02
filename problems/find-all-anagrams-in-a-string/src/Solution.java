import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    /***
     * 滑动窗口加自建哈希加极致优化
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> integerList = new ArrayList<>();
        if(s.length() < p.length()) {
            return integerList;
        }
        int[] hash_s = new int[26];
        int[] hash_p = new int[26];
        int count = 0;//有效字符个数
        int left = 0, right = 0;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        //填入p的哈希成分
        for (int i = 0; i < p.length(); i++) {
            hash_p[pp[i] - 97]++;
        }
        //填入并更新s的哈希成分
        while (right < s.length()) {
            //进入窗口
            if(++hash_s[ss[right] -97] <= hash_p[ss[right] -97]) {
                count++;
            }
            //出窗口
            if(right - left +1 > p.length()) {
                if(hash_s[ss[left] -97]-- <= hash_p[ss[left++] -97]) {
                    count--;
                }
            }
            if(count == p.length()) {
                integerList.add(left);
            }

            right++;
        }

        return integerList;
    }
        /***
         *滑动窗口加哈希表
         */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> integerList = new ArrayList<>();
        if(s.length() < p.length()) {
            return integerList;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        HashMap<Character,Integer> hashMap_s = new HashMap<>();
        HashMap<Character,Integer> hashMap_p = new HashMap<>();
        //提取p的哈希成分
        for (int i = 0; i < p.length(); i++) {
            hashMap_p.put(pp[i], hashMap_p.getOrDefault(pp[i],0) +1);
        }
        //创建s的初始哈希成分
        int right = 0;
        for (; right < p.length(); right++) {
            hashMap_s.put(ss[right], hashMap_s.getOrDefault(ss[right],0) +1);
        }
        //更新并比对s和p的哈希成分
        int left = 0;
        while(right <= s.length()) {
            if(hashMap_s.equals(hashMap_p)) {
                integerList.add(left);
            }
            if(right == s.length()) {
                break;
            }
            //更新s
            hashMap_s.put(ss[right], hashMap_s.getOrDefault(ss[right],0) +1);
            hashMap_s.put(ss[left], hashMap_s.get(ss[left]) -1);
            if(hashMap_s.get(ss[left]) == 0) {
                hashMap_s.remove(ss[left]);
            }
            left++;
            right++;
        }
        return integerList;
    }
}