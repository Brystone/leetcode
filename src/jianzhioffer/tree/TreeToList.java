package jianzhioffer.tree;

import com.sun.org.apache.regexp.internal.RE;
import leetcode.tree.PathSum;
import newcoder.HeapSort;
import sun.reflect.generics.tree.ReturnType;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/2 11:06
 */
public class TreeToList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode TreeToList(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root; //用一个指针指向根节点
        TreeNode pre = null; //中序的前一个结点
        boolean isFirst = true;

        while (cur != null || stack != null) {
            while (cur != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            if (isFirst) {
                root = cur; //第一个结点标记为链表头节点
                pre = cur;
        } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return root;
    }
}
