package Package;

import java.util.Stack;
class Solution {
    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == '{'|| ch[i] == '[' || ch[i] == '(') {
                left.push(ch[i]);
            } else if (left.isEmpty()) {
                return false;
            } else{
                switch (ch[i]){
                    case '}':
                        if(left.peek() == '{'){
                            left.pop();
                            break;
                        }else{
                            return false;
                        }
                        case ']':
                        if(left.peek() == '['){
                            left.pop();
                            break;
                        }else{
                            return false;
                        }
                        case ')':
                        if(left.peek() == '('){
                            left.pop();
                            break;
                        }else{
                            return false;
                        }
                }
            }
        }
        if(!left.isEmpty()){
            return false;
        }
        return true;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        Stack<Character> symbol = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") ||tokens[i].equals("/")){
                int num2 = number.pop();
                int num1 = number.pop();
                switch (tokens[i]){
                    case "+":{
                        number.push(num1 + num2);
                        break;
                    }
                    case "-":{
                        number.push(num1 - num2);
                        break;
                    }
                    case "*":{
                        number.push(num1 * num2);
                        break;
                    }
                    case "/":{
                        number.push(num1 / num2);
                        break;
                    }
                }
            }else{
                number.push(Integer.parseInt(tokens[i]));
            }
        }
        return number.pop();
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pushV int整型一维数组
     * @param popV int整型一维数组
     * @return bool布尔型
     */
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while (j < popV.length) {
                if(stack.isEmpty()){
                    break;
                }
                if (stack.peek() == popV[j]) {
                    stack.pop();
                    j++;
                }else {
                    break;
                }
            }
        }
        if(!stack.isEmpty() || j < popV.length){
            return false;
        }
        return true;
    }
}

public class TTest {
    public static void main(String[] args) {
        int[] a = {2,1,0};
        int[] b = {1,2,0};
        System.out.println(Solution.IsPopOrder(a, b));
    }
}
