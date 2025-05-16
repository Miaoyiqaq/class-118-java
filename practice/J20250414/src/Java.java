import java.util.Scanner;
public class Java {
    private static int count;

    //递归求解汉诺塔问题

    public static  void han(int n , String A, String B ,String C){
        if(n ==1){//将最小的盘子移动到目标柱子
            System.out.println("将" + n + "号圆盘从" + A + "移动到" + B);
        }else{
            han(n - 1, A , C , B);//将n-1视为整体的盘子从原柱子移动到辅组柱子
            System.out.println("将" + n + "号圆盘从" + A + "移动到" + B);
            han(n -1, C , B ,A);//将n-1视为整体的盘子从辅组柱子移动到目标柱子
            //System.out.println("将" + n + "号圆盘从" + A + "移动到" + B);
        }
        count ++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = "原柱子";
        String B = "目标柱子";
        String C = "辅组柱子";
        System.out.print("输入汉诺塔的层数:");
         int n = scanner.nextInt();
        count = 0;
        han(n ,A ,B ,C);
        System.out.println("移动次数为" + count);
    }
    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static int  aa(int n){
        int tmp = 0;
        if(n / 10 == 0){
            return n % 10;
        }else{
            tmp = n;
            return (tmp % 10) + aa(n /= 10);
        }
    }
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(aa(input));
    }
    //迭代求斐波那契数
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        if(input <= 2){
            System.out.println(1);
        }i1 = 1;
        for (int j = 1; j < input; j++){
            i = i1 + i2;
            i2 = i1;
            i1 = i;

        }
        System.out.println(i);
    }
    //递归打印数字的每一位
    public static void ko(int n){
            if((n / 10) == 0){
                System.out.print(n % 10 + " ");
            }else{
                System.out.print(n % 10 + " ");
                ko(n /= 10);
            }
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        ko(input);
    }
    //递归累加
    public static int sum (int n){
        if(n ==1){
            return 1;
        }else{
            return n + sum (n -1);
        }
    }

    public static void main4(String[] args) {
        int a = 9 ;
        System.out.println(sum(a));
    }
    //递归求 N 的阶乘
    public static int aaaaa(int n){
        if(n == 1){
            return 1;
        }else {
            return (n * aaaaa(n -1));
        }
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        System.out.println(aaaaa(inputInt));
    }
    //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
    public static int max(int x, int y) {

        if (x >= y) {

            return x;
        }
        else  {

            return y;
        }
    }

    public static double max(double x, double y, double z) {

        if (x > y && x > z)

            return x;

        else if (y > x && y > z)

            return y;

        else if (z > x && z > y)

            return z;
        else
            return x ;
    }

    public static void main2(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputInt1 = scanner.nextInt();
        int inputInt2 = scanner.nextInt();

        System.out.println(max(inputInt1,inputInt2));

        double inputDb1 = scanner.nextDouble();
        double inputDb2 = scanner.nextDouble();
        double inputDb3 = scanner.nextDouble();

        System.out.println(max(inputDb1,inputDb2,inputDb3));
    }
}