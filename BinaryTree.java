class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public BinaryTree(){
        root = null;
    }

    public void insert(int val){
        root = insertRec(root, val);
    }

    TreeNode insertRec(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(val < root.val){
            root.left = insertRec(root.left, val);
        }else if(val > root.val){
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    public void inorderTraversal(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.println(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    
}
