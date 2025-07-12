class Solution {
    public int firstUniqChar(String s) {
        int[] array = new int[126];
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            array[i]++;
        }
        for (int i = 0; i < s.length(); i++) {
            array[i]++;
            if (array[i] == 2) {
                return ch[i];
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
        String Str = " ";
        System.out.println(Solution1.isPalindrome(Str));

    }
}
