import com.sun.source.tree.Tree;

public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /***
     * 查询是否存在对应的val值
     */
    public TreeNode root;
    public boolean search(int val) {
        if(root == null) {
            return false;
        }
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }else {
                return true;
            }
        }
        return false;
    }

    /***
     * 插入val数据
     */

    public void insert(int val) {
        if(root == null) {
            root = new TreeNode(val);
            return;
        }
        //找到parent的位置,即插入的位置
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                return;
            }
        }
        //通过parent来插入新的带值节点
        TreeNode newNode = new TreeNode(val);
        if(parent.val > val) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
    }

    /***
     * 删除对应val值的节点
     */
    public void remove(int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        //找到对应节点
        while (cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else {
                removeNode(cur,parent);
                return;
            }
        }
    }

    private void removeNode(TreeNode cur,TreeNode parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            }
        } else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            targetParent.val = cur.val;
            if (targetParent == target) {
                targetParent.right = target.right;
            } else {
                targetParent.left = target.right;
            }
        }
    }


}


