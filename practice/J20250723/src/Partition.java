class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {


    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode curN = pHead.next;
        ListNode cur = pHead;
        ListNode end = null;
        ListNode tmp = pHead;
        while (tmp != null) {//找到end节点
            tmp = tmp.next;
            end = tmp;
        }
        while (cur.next != null) {
            if (cur.val < x) {
                end.next = cur;

            }
        }
        return curN;
    }
}