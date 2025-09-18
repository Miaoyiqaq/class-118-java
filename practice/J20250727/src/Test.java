public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        System.out.println("前序遍历");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.println("中序遍历");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.println("后序遍历");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        System.out.println("节点数量");
        System.out.println(binaryTree.size(binaryTree.root));
        System.out.println("叶子数量");
        System.out.println(binaryTree.getLeafNodeCount(binaryTree.root));
        System.out.println("第k层节点数");
        System.out.println(binaryTree.getKLevelNodeCount(binaryTree.root,0));
        System.out.println("二叉树的高度");
        System.out.println(binaryTree.getHeight(binaryTree.root));
        System.out.println("检测有无val的值");
        System.out.println(binaryTree.find(binaryTree.root,6));
    }
}
