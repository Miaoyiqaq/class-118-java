public class Java {
    public static void main(String[] args) {
        Byte a =3;//0000 0011
        Byte b =5;//0000 0101
        Byte c =-3;//1000 0011
        //负数的二进制码是补码,而不是和正数一样(源码反码补码相同)
        //负数的补码是二进制取反+1
        //-3源码:1000 0011(即二进制)
        //-3反码:1111 1100(源码取反,符号位不取反)
        //-3补码:1111 1101(反码加一)
        //-3:1111 1101
        System.out.println(a&b);
        //&计算是二进制同一位都为1则为1,其余均为0
        //3:0000 0011
        //5:0000 0101
        //3&5:0000 0001
        System.out.println(a|b);
        //|计算是二进制同一位中有一位为1则为1,只有全是0时才为0
        //3|5:0000 0111
        System.out.println(a>>1);//>>后的数字代表移多少位
        // >>右移,将二进制数字整体右移一位,且在左边补符号位
        //a>>1:0000 0001
        System.out.println(c>>1);
        //c>>1:1111 1010(补码)
        //c>>1:1111 1001(反码,补码减一)
        //c>>1:1000 0110(原码,反码除了符号位都取反)
        System.out.println(a<<1);
        //<<左移,将二进制数字整体左移一位,且在右边补0
        //a<<1:0000 0110
        System.out.println(c<<1);
        //-c<<1:1111 1010(补码)
        //-c<<1:1111 1001(反码)
        //-c<<1:1000 0110(原码)
        //左移的值可以简单理解为原值翻倍;右移的值为原值除二,但得向下取整
    }

    public static void main3(String[] args) {
        int a =13;
        int b =5;
        System.out.println(a/b);//2
        System.out.println(-a/b);//-2
        System.out.println(a/-b);//-2
        System.out.println(-a/-b);//2
        //除法运算中的符号是由被除数和除数的符号共同决定的
        System.out.println(a%b);//3
        System.out.println(-a%b);//-3
        System.out.println(a%-b);//3
        System.out.println(-a%-b);//-3
        //取模运算中的符号是由被除数的符号决定的,与除数无关

    }
    public static void main2(String[] args) {
        Byte a =20;
        Byte b =30;
        System.out.println(a+b);
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
        System.out.println(("b = "+b));
        System.out.println(a + b + " = a + b");
        //字符串前打印的的加号是可以进行赋值运算的,字符串后面打印的加号是个连接符号,不能进行赋值运算

    }
    public static void main1(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }

    
}
