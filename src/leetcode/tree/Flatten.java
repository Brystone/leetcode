package leetcode.tree;

import java.util.*;

/**
 * 题目：114. 二叉树展开为链表
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/19 20:35
 */
public class Flatten {
    public void flatten(TreeNode root) {
        //1.先序遍历

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return; //默认为空
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null; //当前遍历结点的上一个结点，
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            //将右指针变为当前遍历结点，左指针置为空
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            pre = node;
        }
    }
}
