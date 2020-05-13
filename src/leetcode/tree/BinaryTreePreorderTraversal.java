package leetcode.tree;

/*
144M. Binary Tree Preorder Traversal 二叉树先序遍历  T(n) = O(n)  S(n) = O(n)
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list; //默认为空
        }
        Stack<TreeNode> stack = new Stack<>();
        //先将根节点压栈
        stack.push(root);
        //遍历栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //结点值存入数组中
            list.add(node.val);
            //借助栈的元素出栈顺序实现 前序遍历先是访问左子树
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
