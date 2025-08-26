package MyLinkedList;

public class MyLinkedList {
    public static class LinkNode {
        private int val;
        private LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }

    }

    private LinkNode head;//头地址

    public void createNode() {
        LinkNode node = new LinkNode(3);
        LinkNode node1 = new LinkNode(5);
        LinkNode node2 = new LinkNode(7);
        LinkNode node3 = new LinkNode(9);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        this.head = node;
    }

    public void addFirst(int val) {//头插法
        if (head == null) {
            head = new LinkNode(val);
        } else {
            LinkNode addNode = new LinkNode(val);
            addNode.next = head;
            head = addNode;
        }
    }

    public void addLast(int val){//尾插法
        LinkNode tmp = head;
        if(tmp == null){
            head = new LinkNode(val);
            tmp = head;
        }
        else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
        }
        tmp.next = new LinkNode(val);
    }
    //任意位置插⼊,第⼀个数据节点为0号下标
    public void addIndex(int index,int val){
        if(index < 0 || index > size()){
            throw new IllegalIndexException("非法的下标:下标应为0~" + size() );
        }
        if(index == 0){
            addFirst(val);
            return;
        }
        if(index == size()){
            addLast(val);
            return;
        }
        //插入位置的前一个节点
        LinkNode previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        //插入的后一位元素就是前一个节点的后一个节点
        //所以后一个节点就是previous.next
        LinkNode after = previous.next;
        LinkNode tmp = new LinkNode(val);
        previous.next = tmp;
        tmp.next = after;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        LinkNode tmp = head;
        while (tmp != null){
            if(tmp.val == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    //删除第⼀次出现关键字为key的节点
    public void remove(int key){
       LinkNode tmp = head;
        for (int i = 0; i < size(); i++) {
            if(tmp.val == key){
                remIndex(i);
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("没找到" + key);
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(head == null){
            System.out.println("链表为空,无法删除");
        }
        int sz = size();
        while (sz-- != 0) {
            LinkNode tmp = head;
            for (int i = 0; i < sz; i++) {
                if (tmp.val == key) {
                    remIndex(i);
                    break;
                }
                tmp = tmp.next;
            }
        }
        System.out.println("链表中已无:" + key);
    }
    public void remIndex (int index){
        if(index < 0 || index > size()){
            throw new IllegalIndexException("非法的下标:下标应为0~" + size() );
        }
        if(index == 0){
            head =head.next;
            return;
        }
        LinkNode tmp = head;
        while (--index != 0){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
    }
    /***
     * @return 返回链表长度
     */
    public int size() {
        LinkNode ret = head;//用ret临时存放头地址
        int count = 0;//计数
        while (ret != null){//判断当前节点的下一个节点地址是否为空
            count++;
            ret = ret.next;
        }
        return count;
    }

    /***
     * 打印链表所有元素
     */
    public void display(){
        LinkNode ret = head;//用ret临时存放头地址
        while (ret != null){//判断当前节点的下一个节点地址是否为空
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
        System.out.println();
    }
}

