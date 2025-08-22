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

    public void addFirst(int val){//头插法
        LinkNode addNode = new LinkNode(val);
        addNode.next = head;
        head = addNode;
    }

    public void addLast(int data){//尾插法
        LinkNode tmp = head;
        while (tmp != null){
            tmp
        }
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

