package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：102. 二叉树的层序遍历  O(n) 队列来做
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/7 10:11
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        Queue<TreeNode> quene = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        quene.add(root);
        
        while (!quene.isEmpty()) {
            ArrayList<Integer> tmp =new ArrayList<>(); //每一层都
            //遍历一层
            int size = quene.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = quene.poll();
                tmp.add(node.val);
                if (node.left != null) quene.add(node.left);
                if (node.right != null) quene.add(node.right);
            }
            //一层结束后添加结果
            res.add(tmp);
        }
        return res;
    }
}
