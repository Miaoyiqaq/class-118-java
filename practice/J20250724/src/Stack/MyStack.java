package Stack;

import Stack.StackEmptyException;

import java.util.Arrays;

public class MyStack extends StackEmptyException {
    public int[] elem;
    public int usedSize = 0;

    public MyStack() {
        elem = new int[2];
    }
    public void push(int val){
        int size = elem.length;
        if(size == usedSize){
            elem = Arrays.copyOf(elem,size*2);
        }
        elem[usedSize] = val;
        usedSize++;
    }
    public int pop() {
        if(isEmpty()){
            throw new StackEmptyException();
        }
        usedSize--;
        return elem[usedSize];
    }

    public int peek() {
        if(isEmpty()){
            throw new StackEmptyException();
        }
        return elem[usedSize -1];
    }

    public boolean contains(int key) {
        for (int i = 0; i < usedSize; i++) {
            if(elem[i] == key) {
                return true;
            }
        }return false;
    }

    public boolean isEmpty() {
        if(usedSize == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size() {
        return usedSize;
    }

    public void clear() {
        elem = new int[2];
        usedSize = 0;
    }
    public void StackToString() {
        System.out.print('[');
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println("]");
    }
}
