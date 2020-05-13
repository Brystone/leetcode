package leetcode.tree;

/*
111 E. Minimum Depth of Binary Tree 树的最小路径
 */
public class MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //求树的最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //如果子树为空，返回子树深度之和
        if (left == 0 || right == 0) {
            return left + right + 1; //这里的返回是把0加上，
        }
        return Math.min(left, right) + 1;
    }
}
