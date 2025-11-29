import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = 0;
        int n = scanner.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            long num = 0;
            for (int j = i +1; j < n; j++) {
                num += data[j];
            }
            count += data[i] * num;
        }
        System.out.println(count);
    }
}