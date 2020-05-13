package leetcode.tree;
/*
110E: Balanced Binary Tree  O(n)
    3
   / \
  9  20
    /  \
   15   7
 */

public class BalancedBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left); //为空就是0
        int r = maxDepth(root.right);
        if (Math.abs((l - r)) > 1) {
            res = false;
        }
        return Math.max(l, r) + 1;
    }
}
