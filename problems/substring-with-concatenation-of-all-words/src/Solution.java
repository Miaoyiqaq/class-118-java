import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    //滑动窗口加哈希
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> integerList = new ArrayList<>();
        int wordsNum = words.length;//单词数量
        int wordsLength = words[0].length();//单词长度
        if(wordsNum * wordsLength > s.length()) {
            return integerList;
        }
        HashMap<String, Integer> hash1 = new HashMap<>();// 存储对应单词表
        for (String str:
                words
             ) {
            hash1.put(str,hash1.getOrDefault(str,0) +1);
        }
        for (int i = 0; i < wordsLength; i++) {//遍历每种可能性
            HashMap<String, Integer> hash2 = new HashMap<>();// 当前存储的字符串
            int count = 0;//有效字符串个数
            for (int left = i, right = i; right + wordsLength <= s.length() ; right += wordsLength) {
                //进窗口
                String current = s.substring(right,right + wordsLength);//当前字符串
                hash2.put(current,hash2.getOrDefault(current,0) +1);
                if(hash2.get(current) <= hash1.getOrDefault(current,0)) {
                    count++;
                }
                //出窗口
                if(right - left +1 > wordsLength * wordsNum) {
                    current = s.substring(left, left + wordsLength);
                    if(hash2.get(current) <= hash1.getOrDefault(current,0)) {
                        count--;
                    }
                    hash2.put(current,hash2.get(current) -1);
                    left += wordsLength;
                }
                if(count == wordsNum) {
                    integerList.add(left);
                }
            }
        }
        return integerList;
    }
}