package Stack;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(0);
        myStack.StackToString();
        System.out.println(myStack.contains(3));

    }
}
