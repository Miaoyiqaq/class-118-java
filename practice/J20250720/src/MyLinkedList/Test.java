package MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createNode();
        myLinkedList.display();
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(0);
        myLinkedList.addLast(99);
        myLinkedList.addIndex(2,12);
        myLinkedList.display();
       // myLinkedList.remIndex(0);
      //  myLinkedList.remove(0);
       myLinkedList.removeAllKey(0);
      //  System.out.println(myLinkedList.contains(99));
        System.out.println(myLinkedList.size());
        myLinkedList.display();
    }
}
