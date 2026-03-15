public class Test {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,888);
        hashBuck.put(12,888);
        hashBuck.put(2,888);
        hashBuck.put(14,888);
        hashBuck.put(4,888);
        hashBuck.put(8,888);
        hashBuck.put(7,888);
        hashBuck.put(5,888);
        hashBuck.put(6,888);
    }
    public static void main1(String[] args) {
        int[] array = {5,10,3,1,15};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        System.out.println(binarySearchTree.search(0));
    }
}
