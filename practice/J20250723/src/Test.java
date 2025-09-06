public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.display();
        System.out.println("================");
        myLinkedList.removeAllKey(1);
        myLinkedList.display();

        //System.out.println(myLinkedList.contains(0));
    }
}
