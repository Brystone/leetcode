package jianzhioffer.tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeTopToDown {
    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode root;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    private static List<BinaryTreeNode> printTreeTopToDown(BinaryTreeNode root) {  //泛型方法
        if (root == null) {
            return null;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<BinaryTreeNode> list = new ArrayList<>(); //存放队列得元素
        queue.offer(root);

        while (queue != null) {
            //出队列
            BinaryTreeNode node = queue.poll();
            list.add(node);

            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left); //放进队列遍历
            }
        }
        return list;
    }
}
