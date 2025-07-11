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

class Solution1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length();
        boolean k = true;
        while (i < j) {
            char[] ch = s.toCharArray();
            for (i = 0; i < s.length(); i++) {
                if (ch[i] > 96 && ch[i] < 123) {
                    for (j = s.length(); j > 0; j--) {
                        if (ch[i] > 96 && ch[i] < 123) {
                            if (ch[i] != ch[j]) {
                                k = false;
                            }
                        }

                    }

                }
            }
        }
        return k;
    }
}
public class Test {
    public static void main(String[] args) {
        String Str = "A man, a plan, a canal: Panama";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isPalindrome(Str));

    }
}
