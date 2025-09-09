import java.util.List;

public class MyLinkedList implements IMyLinkedList{
    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(){

        }
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;

    @Override
    public void addFirst(int data) {
        ListNode listNode = new ListNode(data);
        if(head == null){
            createNull(listNode);
        }else{
            head.prev = listNode;
            listNode.next = head;
            head = head.prev;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        if(head == null){
            createNull(listNode);
        }else{
            ListNode tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = listNode;
            listNode.prev = tmp;
        }

    }

    /**
     * 任意位置插入,第一个数据节点为0号下标
     * @param index
     * @param data
     * @return
     */
    @Override
    public void addIndex(int index, int data) {
        int sz = size();
        if(index < 0 || index > sz){
            System.out.println("不合法的下标.链表长度为" + sz);
            return;
        }else if(index == 0){
            addFirst(data);
            return;
        } else if (index == sz) {
            addLast(data);
            return;
        }
        ListNode tmp = head;
        while(index-- != 0){
            tmp = tmp.next;
        }
        ListNode node = new ListNode(data);
        node.prev = tmp.prev;
        tmp.prev.next = node;
        node.next = tmp;
        tmp.prev = node;

    }

    /**
     * 查找是否包含关键字key是否在单链表当中
     * @param key
     * @return
     */
    @Override
    public boolean contains(int key) {
        if(head == null){
            return false;
        }
        ListNode tmp = head;
        while (tmp != null){
            if(tmp.val == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        ListNode tmp = head;
        if(head.val == key){
            head = head.next;
            head.prev = null;
            return;
        }
        while(tmp.next != null){
            if(tmp.val == key){
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                return;
            }
            tmp = tmp.next;
        }
        if(tmp.val == key){
            tmp.prev.next = null;
            return;
        }
        System.out.println("未找到" + key);
    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = head.next;
        ListNode curN = cur.next;
        while (cur.next != null) {
            if (cur.val == key) {
                cur.prev.next = curN;
                cur.prev = null;
            }
            cur = curN;
            curN = cur.next;
        }
        if(cur.val == key){
            cur.prev.next = null;
        }
        while(head.val == key){
            head = head.next;
            if(head == null){
                return;
            }
            head.prev = null;
        }
    }

    @Override
    public int size() {
        int sz = 0;
        ListNode tmp = head;
        while(tmp != null){
            tmp = tmp.next;
            sz++;
        }
        return sz;
    }

    @Override
    public void display() {
        if(head == null){
            System.out.println("null");
        }else{
            ListNode tmp = head;
            while (tmp != null){
                System.out.print(tmp.val + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        head = null;
    }
    private void createNull(ListNode node){
        head = node;
        last = head;
    }
}
