import java.util.HashMap;
import java.util.Objects;

class Solution {
    public String minWindow(String s, String t) {
        String ret = "";
        if(t.length() > s.length()) {
            return ret;
        }
        boolean flag = false;
        char[] tt = t.toCharArray();
        HashMap<Character, Integer> hash_t = new HashMap<>();
        //存入哈希表
        for (char c :
                tt) {
            hash_t.put(c, hash_t.getOrDefault(c,0) +1);
        }
        HashMap<Character, Integer> hash_s = new HashMap<>();
        int start = 0;//最小字符串的起始位置
        int length = s.length();//最小字符串的长度
        int right = 0, left = 0;
        int count = 0;//有效字母的种类
        for (; right < s.length(); right++) {
            //进窗口
            if (count < hash_t.size()) {
                hash_s.put(s.charAt(right), hash_s.getOrDefault(s.charAt(right),0) +1);
                if(Objects.equals(hash_s.get(s.charAt(right)), hash_t.get(s.charAt(right)))) {
                    count++;
                }
            }
            while (count == hash_t.size()) {
                //判断条件
                int currentLength = right - left +1;
                if(currentLength <= length) {
                    flag = true;
                    length = currentLength;
                    start = left;
                }
                //出窗口

                if(Objects.equals(hash_s.get(s.charAt(left)), hash_t.get(s.charAt(left)))) {
                    count--;
                }
                hash_s.put(s.charAt(left), hash_s.getOrDefault(s.charAt(left++),0) -1);
            }

        }
        if(flag) {
            ret = s.substring(start, start + length);
        }
        return ret;
    }
}