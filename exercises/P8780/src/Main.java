import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long n = scanner.nextLong();
        long week = n/(5*a + 2*b);
        long day = 0;
        day += 7*week;
        long residual = n % (5*a + 2 *b);
        if(residual == 0) {
            System.out.println(day);
            return;
        }
        if( residual <= 5 * a) {
            day += (residual+a-1) / a;
        }
        if(residual > 5 * a) {
            day += ((residual - (5*a)) + b -1) / b + 5;
        }
        System.out.println(day);
    }
}
