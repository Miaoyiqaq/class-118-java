import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = "";
        while(in.hasNextLine()){
            String str = in.next();
            Pattern pattern = Pattern.compile("\\d+");
        //pattern类的作用是将字符串重编译为机器更易读的对象.在大量且重复的比对中有更好的效率
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()){
                String cur = matcher.group();
                if(cur.length() > tmp.length()){
                    tmp = cur;
                }
            }
            System.out.println(tmp);
            tmp = "";
        }
    }
}
