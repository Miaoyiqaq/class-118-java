package MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //myLinkedList.createNode();
        //myLinkedList.display();
        myLinkedList.addLast(1);
        myLinkedList.addLast(3);
        myLinkedList.addLast(5);
        myLinkedList.addLast(3);
        myLinkedList.addLast(1);
        myLinkedList.display();
        System.out.println("===========================");
       // myLinkedList.remIndex(0);
      //  myLinkedList.remove(0);
       //myLinkedList.removeAllKey(0);
      //  System.out.println(myLinkedList.contains(99));
      //  System.out.println(myLinkedList.size());
        boolean ret = PalindromeList.chkPalindrome(myLinkedList.head);
        System.out.println(ret);
     //   myLinkedList.display();
    }
}
class PalindromeList {
    public static boolean chkPalindrome(MyLinkedList.LinkNode A) {
        if(A == null && A.next == null){
            return true;
        }
        // write code here
        //MyLinkedList.LinkNode head = A;
        MyLinkedList.LinkNode fast = A;
        MyLinkedList.LinkNode slow = A;
        while(fast != null && fast.next != null){//找到中间节点
            fast = fast.next.next;
            slow = slow.next;
        }
        MyLinkedList.LinkNode cur = slow.next;
        while(cur != null){//后半链表反向
            MyLinkedList.LinkNode nextTemp = cur.next;
            cur.next = slow;
            slow = cur;
            cur = nextTemp;
        }
        while(head != fast && head.next == fast){
            if(head.val != fast.val){
                return false;
            }
        }
        return true;
    }
}
