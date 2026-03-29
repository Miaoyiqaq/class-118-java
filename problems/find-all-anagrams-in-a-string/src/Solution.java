import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> integerList = new ArrayList<>();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        if(s.length() < p.length()) {
            return integerList;
        }
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