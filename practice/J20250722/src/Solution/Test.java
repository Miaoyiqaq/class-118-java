package Solution;


import java.util.List;

// Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
      
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur;
        ListNode curN;
        cur = head.next;//current operation node
        head.next = null;
        while (cur != null) {
            curN = cur.next;//save next operation node information
            cur.next = head;//move the current operation node to the front of the head node
            head = cur;
            cur = curN;
        }
        return head;
    }

    }


public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

       ListNode reversed = Solution.reverseList(head);
        System.out.println();
        reversed.toString();
    }

}