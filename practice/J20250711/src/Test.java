class Solution {
    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

class Solution1 {//判断回形字符
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();//将字符串中大写字母改为小写
        int i = 0;
        int j = s.length() -1;
        char[] ch = s.toCharArray();//将字符串转化为char数组
        while (i <= j) {//用双指针判断
            while (i < j && !Character.isLetterOrDigit(ch[i])) {//如果字符i不是字母则跳过
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(ch[j])) {//如果字符i不是字母则跳过
                j--;
            }
            if (ch[i] != ch[j]) {//判断两个指针的字符是否不同
                return false;
            }
            if(i > j){
                return true;
            }
            i++;
            j--;
        }return true;
    }
}
public class Test {
    public static void main(String[] args) {
        String Str = "leetcode";
        System.out.println(Solution.firstUniqChar(Str));
    }
}

//        int[] arr = new int[26];//定义一个26元素的数组
//        int n = s.length();//s字符串的长度为n
//        for (int i = 0; i < n; i++) {//字符内for循环
//            arr[s.charAt(i) - 'a']++;//获取到的字符减去字符a来得到正确的字母位置
//        }
//        for (int i = 0; i < n; i++) {//二次字符内for循环,当这次循环中的第一个在arr元素中出现的2则为第一个不重复字符
//
//            if (arr[s.charAt(i) - 'a'] == 1) {
//                //判断是否为第一个字符
//                return i;
//            }
//        }
//        return -1;
//        //返回判断出的字符
//        //如果没找到则返回-1
//    }
