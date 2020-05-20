package jianzhioffer.tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

public class PrintTreeWithZ {
    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode root;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    public void printTreeWithZ(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<BinaryTreeNode> stackOdd = new LinkedList<>();
        LinkedList<BinaryTreeNode> stackEven = new LinkedList<>();

        stackOdd.push(root);//奇数栈先存根节点

        //遍历两个栈，只要有一个不为空也要输出
        while (stackEven != null || stackOdd != null) {
            if (stackOdd != null) { //偶数栈为空
                while (stackOdd != null) {
                    BinaryTreeNode node = stackOdd.pop();
                    System.out.println(node.value);
                    if (node.left != null) { //从左至右加入偶数栈
                        stackEven.push(node.left);
                    }
                    if (node.right != null) {
                        stackEven.push(node.right);
                    }
                }
            } else {
                while (stackEven != null) { //遍历栈输出,将奇数层节点压入奇数栈
                    BinaryTreeNode node = stackEven.pop();
                    System.out.println(node.value);
                    if (node.right != null) {
                        stackOdd.push(node.right);
                    }
                    if (node.left != null) {
                        stackOdd.push(node.left);
                    }
                }
            }
        }
    }
}
