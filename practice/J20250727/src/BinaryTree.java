public class BinaryTree {
     int val;
    BinaryTree left;
    BinaryTree right;

    public int getVal() {
        return val;
    }

    public BinaryTree(int val) {
        this.val = val;
    }

    public BinaryTree(){

    }
    public BinaryTree root;

    public void createBinaryTree(){
        BinaryTree A = new BinaryTree(1);
        BinaryTree B = new BinaryTree(2);
        BinaryTree C = new BinaryTree(3);
        BinaryTree D = new BinaryTree(4);
        BinaryTree E = new BinaryTree(5);
        BinaryTree F = new BinaryTree(6);

        root = A;
        A.left = B;
        B.left = D;
        B.right = E;
        A.right = C;
        C.right = F;
    }

    // 前序遍历
    public void preOrder(BinaryTree root){
        if(root == null){
            return;
        }
        System.out.print(root.getVal() + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历
    public void inOrder(BinaryTree root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.getVal() + " ");
        inOrder(root.right);
    }
    // 后序遍历
    public void postOrder(BinaryTree root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.getVal() + " ");
    }

    // 获取树中节点的个数
    public int size(BinaryTree root){
        if(root == null){
            return 0;
        }
        return size(root.left) + size(root.right) +1;
    }
    // 获取叶⼦节点的个数
    int getLeafNodeCount(BinaryTree root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }
    // ⼦问题思路-求叶⼦结点个数
// 获取第K层节点的个数
    int getKLevelNodeCount(BinaryTree root,int k){
        if(root == null){
            return 0;
        }
        if(k - 1 == 0){
            return 1;
        }
        return getKLevelNodeCount(root.left,k -1) + getKLevelNodeCount(root.right,k -1);
    }
    // 获取二叉树的高度
    int getHeight(BinaryTree root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) +1;
    }
    // 检测值为value的元素是否存在
    Boolean find(BinaryTree root, int val){
        if(root == null){
            return false;
        }
        if(root.getVal() == val){
            return true;
        }
        return find(root.left,val) || find(root.right,val);
    }
    //层序遍历
    void levelOrder(BinaryTree root){
        if(root == null){
            return ;
        }

    }
    // 判断⼀棵树是不是完全⼆叉树
    boolean isCompleteTree(BinaryTree root){
        return true;
    }
}
