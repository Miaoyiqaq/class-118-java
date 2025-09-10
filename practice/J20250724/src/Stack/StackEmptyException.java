package Stack;

public class StackEmptyException extends RuntimeException{
    public StackEmptyException() {
        super("栈为空,别想操作了");
    }
}
