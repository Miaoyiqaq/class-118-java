import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.Scanner;
public class Java {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            for(int i = 0 ; i < a ; i ++){
                for(int j = 0 ; j < a ; j++){
                    if(i == j || (i + j) == a -1){
                        System.out.print('*');
                    }else{
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }

    //求出0～n之间的所有“水仙花数”并输出
    //(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，如；153＝1^3＋5^3＋3^3，则153是一个“水仙花数“。）
    public static void main6(String[] args) {
        int tmp,j;
        int k = 0;
        for(int i = 100 ; i < 1000 ; i++){
            tmp = i ;
            k = 0;
            while(1 > 0){
                j = tmp % 10;
                k = k + (int)Math.pow(j,3);
                if(tmp / 10 == 0){
                    break;
                }
                tmp /= 10;
            }
            if(i == k){
                System.out.print(i + " ");
            }
        }
    }
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static void main5(String[] args) {
        double b,c;
        c =0.0;
        for(b = 1 ; b <= 100 ; b ++) {
            if (b % 2 != 0) {
                c += 1.0 / b;
            } else if (b % 2 == 0) {
                c -= 1.0 / b;
            }
        }System.out.println(c);
    }
    //给定两个数，求这两个数的最大公约数
    //例如:
    //输入：20 40
    //输出：20
    public static void main4(String[] args) {

        int a = 48;
        int b = 18;
        int i,j,k,r;
        if(a > b){
            i = a;
            j = b;
        } else  {
            i = b;
            j = a;
        }
        while(1 >0){
            r = i % j;
            i = j;
            j = r;
            if(r == 0){
                System.out.println(i);
                break;
            }
        }


    }
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main3(String[] args) {
        int tmp;
        int tmp1= 0;
        int count =0;
        for(int i = 1;i <= 100;i++){
            tmp = i;
            while(tmp != 0){
                tmp1 =tmp;
                tmp %= 10;
                if(tmp == 9){
                    count++;
                }
                tmp = tmp1;
                tmp /= 10;
            }
        }
        System.out.println(count);
    }
    //打印1000~2000的闰年
    public static void main2(String[] args) {
        for(int i = 1000;i <= 2000; i++){
            if ((i % 4 == 0 && i % 100!= 0 ) || (i % 400 == 0)) {
                System.out.print(i + " ");
            }
        }
    }
    //打印素数
    public static void main1(String[] args) {
        int i;
        int j = 2;
        boolean k = true;
        for(i = 2; i<=100 ; i++)
        {
            k = true;
            for(j = 2; i > j ; j++)
            {
                if(i % j == 0)
                {
                    k = false;
                    break;
                }
            }
            if(k == true)
            {
                System.out.print(i + " ");
            }
        }
    }
}
