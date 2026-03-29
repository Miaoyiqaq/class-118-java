class Solution {
    public int sums(int n) {//计算每个位置上的数字平方和
        int sum = 0;
        if(n == 0){
            return 0;
        }
        while(n / 10 != 0 || n % 10 != 0){
            //可优化逻辑为while(n != 00
            int tmp = n % 10;
            sum += (int)Math.pow(tmp,2);
            //可优化逻辑为sum += tmp * tmp
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {//快慢双指针
        int fast = n;
        int slow = n;
        while(true) {
            fast = sums(sums(fast));
            slow = sums(slow);
            if(fast == slow) {
                return fast == 1;
            }
        }
    }
}
public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
