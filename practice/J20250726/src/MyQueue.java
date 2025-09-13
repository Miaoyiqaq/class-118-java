import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    
    public void push(int x) {
        s1.offer(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.offer(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.offer(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */