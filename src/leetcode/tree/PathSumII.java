package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：113. 路径总和 II M
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/18 21:35
 */
public class PathSumII {
    List<List<Integer>> listAll = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return listAll;
        list.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        list.remove(list.size()-1);
        return listAll;
    }
}
