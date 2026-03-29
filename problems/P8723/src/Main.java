import java.util.Scanner;

public class Main {
    public static String setBase(int base ,int num) {
        int left,right;
        left = num / base;
        right = num % base;
        String l,r;
        if(left >= 10) {
            l = String.valueOf((char)(55 + left));
        } else if (left > 0) {
            l = String.valueOf((char)(48 +left));
        }else l = "";
        if(right >= 10) {
            r = String.valueOf((char)(55 + right));
        } else if (right >= 0) {
            r = String.valueOf((char)(48 +right));
        }else r = "";
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append(r);
        String lr = sb.toString();
        return lr;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        for (int i = 1; i <= base -1; i++) {
            for (int j = 1; j <= i; j++) {
                int tmp = i *j;
                //处理进制
                //setBase(base,tmp);
                System.out.print(setBase(base,i) + "*" + setBase(base,j) + "=" + setBase(base,tmp) + " ");
            }
            System.out.println();
        }
    }
}
