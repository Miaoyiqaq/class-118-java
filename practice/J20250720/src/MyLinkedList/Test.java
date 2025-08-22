package MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createNode();
        System.out.println(myLinkedList.size());
        myLinkedList.display();
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(0);
        myLinkedList.display();
    }
}
