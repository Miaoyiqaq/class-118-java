public class Test {
    public static void main(String[] args) {
        int[] array = {5,10,3,1,15};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        System.out.println(binarySearchTree.search(0));
    }
}
