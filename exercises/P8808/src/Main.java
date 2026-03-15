import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arrLenght = scanner.nextInt();
        int count = 0;
        int fib1 = 1;
        int fib2 = 1;
        for (int i = 1; i <= arrLenght; i++) {
            if (i <= 2) {
                if (scanner.nextInt() != 1) {
                    count++;
                }
            } else {
                int fib = fib1 + fib2;
                if (fib != scanner.nextInt()) {
                    count++;
                }
                fib2 = fib1;
                fib1 = fib;
            }
        }
        System.out.println(count);
    }
}
