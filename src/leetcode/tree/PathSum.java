package leetcode.tree;

import com.sun.org.apache.regexp.internal.REUtil;

/*
112 E . Path Sum  sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

递归解法
 */
public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //只有根节点 路径的定义
        if (root.left == null && root.right == null && root.val== sum) {
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
