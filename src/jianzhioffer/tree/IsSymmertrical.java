package jianzhioffer.tree;

/*
镜像树
 */
public class IsSymmertrical {
    private static class TreeNode  {
        int val;
        TreeNode  left;
        TreeNode  right;
        TreeNode  root;

        public TreeNode (int value) {
            this.val = value;
        }
    }

    public static boolean isSymmertrical(TreeNode  root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);

    }

    public static void main(String[] args) {
        TreeNode  root1 = new TreeNode (5);
        root1.left = new TreeNode (3);
        root1.right = new TreeNode (4);
        root1.left.left = new TreeNode (6);
        root1.left.right = new TreeNode (7);
        root1.right.left = new TreeNode (8);
        root1.right.right = new TreeNode (9);

        TreeNode  root2 = new TreeNode (5);
        root2.left = new TreeNode (4);
        root2.right = new TreeNode (3);
        root2.left.left = new TreeNode (9);
        root2.left.right = new TreeNode (8);
        root2.right.left = new TreeNode (7);
        root2.right.right = new TreeNode (6);

        //System.out.println(isSymmertrical(root1, root2));
    }
}
