package jianzhioffer.tree;

import java.util.LinkedList;
import java.util.Queue;

/* depth = 3
    3
   / \
  9  20
    /  \
   15   7
1:递归版本:遍历左子树，遍历右子树 最后加上根节点的值 理解递归的本质
 */
public class TreeDepth {
    private class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        private BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    private int treeDepth1(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int left =  treeDepth1(root.left);
        int right = treeDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    //非递归,BFS层序遍历
    private int treeDepth2(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        //用队列存储树的结点,元素出队列时，出1个，进2.然后循环两次
        Queue<BinaryTreeNode> queue = new LinkedList<>(); //FIFO
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int queneSize = queue.size();
            for (int i=0; i<queneSize; i++) {
                BinaryTreeNode node = queue.poll(); //根结点弹出
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    //输入一颗二叉树，判断是否是平衡二叉树(左右子树深度差<=1)
    private boolean isBanlancedTree(BinaryTreeNode root) {
        return depth(root)>=0; //表达式的结果为boolean型
    }

    private int depth(BinaryTreeNode root) {
        //在这里判断树是否为空
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left>0 && right>0 && Math.abs(left - right) <= 1 ? Math.max(left, right) : -1; //左右都要子树
    }
}
