import java.util.Scanner;

class treeNode{
    public treeNode(char val) {
        this.val = val;
    }
    public treeNode(){

    }
    treeNode left;

    treeNode right;
  char val;
}
public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            inOrder(create(str));
        System.out.println();
        }
    }
    public static treeNode create(String ret){
        treeNode root = null;
            if(ret.charAt(count) != '#'){
                root = new treeNode(ret.charAt(count));
                count++;
                root.left = create(ret);
                root.right = create(ret);
            }else {
                count++;
            }
            return root;
        }

    public static void inOrder(treeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}