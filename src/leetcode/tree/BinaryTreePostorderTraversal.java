package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
145 H. Binary Tree Postorder Traversal 后序遍历
 */
public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list; //默认为空
        }
        Stack<TreeNode> stack = new Stack<>();
        //先将根节点压栈
        stack.push(root);
        //遍历栈
        while (!stack.isEmpty()) {
            //根节点先出栈
            TreeNode node = stack.pop();
            //结点值存入数组中
            list.add(node.val);
            //借助栈的元素出栈顺序实现 前序遍历先是访问左子树
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list); // 根->右->左  左->右—>根
        return list;
    }
}
