package leetcode.tree;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementinaBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
/*
二叉搜索树里的元素有序，非递归的中序遍历得到有序的数组，遍历数组得到第k个数即可
 */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        res = inOrder(root);
        return res.get(k-1);
    }

    public ArrayList<Integer> inOrder(TreeNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //遍历结点的指针
        TreeNode cur = node;

        while (cur != null || !stack.isEmpty()) {
            // 先将根节点和左子树的左节点 进栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node1 = stack.pop();  //从左子树树最左的一个结点出栈
            list.add(node1.val);
            cur = node.right; // 将子树根节点的右节点入栈
        }
        return list;
    }
}
