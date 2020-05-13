package leetcode.tree;
/*
404 E. Sum of Left Leaves
    3
   / \
  9  20
    /  \
   15   7

9+15 = 24
 */


public class SumofLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //判断一个结点
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right); //递归
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    //判断是否是叶结点
    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
