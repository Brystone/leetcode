package leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Double> list = new ArrayList<>(); // 存储平均值
        Queue<TreeNode> queue = new LinkedList<>(); //使用队列存储树的结点
        queue.add(root);

        //遍历队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            // 计算队列里的元素值总和
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                //结点入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sum / size);
        }
        return list;
    }
}
