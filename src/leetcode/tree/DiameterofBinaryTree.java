package leetcode.tree;

/*
543. Diameter of Binary Tree
          1
         / \
        2   3
       / \
      4   5
   Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
   经过左子树和右子树，将两个子树的深度相加即可
 */
public class DiameterofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root);
        int r = depth(root);
        max = Math.max(max, l+r);
        return Math.max(l, r) + 1;
    }
}
