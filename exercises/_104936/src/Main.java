import java.util.Scanner;

public class Main {
    public static boolean isSqrt(String num) {//判断能否整开根
        long i = Long.parseLong(num);
        long j = (long)Math.sqrt(i);
        return j * j == i;
    }
    public static boolean isSq(String num) {
        for (int i = 1; i < num.length(); i++) {
            String left = num.substring(0,i);
            String right = num.substring(i);
            if(isSqrt(left) && isSqrt(right) && Integer.parseInt(right) != 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        for (long i = min; i < max; i++) {
            String str = Long.toString(i);
            if(isSqrt(str) && isSq(str)) {
                System.out.println(str);
            }
        }
    }
}