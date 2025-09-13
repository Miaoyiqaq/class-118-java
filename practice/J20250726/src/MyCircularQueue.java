class MyCircularQueue {
    int[] elem;
    int front = 0;
    int rear = 0;
    int size = 0;
    public MyCircularQueue(int k) {
        elem = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        elem[front] = value;
        if((front + 1) == elem.length){
            front = 0;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if((rear + 1) == elem.length){
            rear = 0;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return elem[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return elem[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == elem.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */