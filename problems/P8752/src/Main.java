import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 5;
        int val = 0;
        while (count-- != 0) {
            int tmp = Integer.parseInt(scanner.nextLine());
            if(isYear(tmp)) {
                val++;
            }

        }
        System.out.println(val);

    }

    private static boolean isYear(int tmp) {
        int a = tmp%10;
        int b = (tmp/10)%10;
        int c = (tmp/100)%10;
        int d = tmp/1000;
        return d == b && a == c +1;
    }
}
