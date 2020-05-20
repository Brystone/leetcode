package leetcode.tree;

import java.util.Stack;

/**
 * 题目：98. 验证二叉搜索树 左边结点都比根结点小，右边都比这大
 * 思路： 二叉搜索树的中序遍历是有序的，只要比较当前元素和后一元素即可
 *
 * @author ：stone
 * @date ：Created in 2020/3/25 11:50
 */
public class IsValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
