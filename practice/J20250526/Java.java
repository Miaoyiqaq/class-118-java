import java.util.Scanner;
public class Java {

    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Data data = new Data(x, y);
                System.out.println(data.getX() + data.getY());
            }
        }

    }

    class Data {

        private int x;
        private int y;

        private Data(int x, int y) {
            x = x;
            y = y;
        }

        private int getX() {
            return x;
        }

        private int getY() {
            return y;
        }

    }
}
