package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName Combine
 * @Description 77. 组合 M
 * @date 2020/5/12 19:09
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, new ArrayList<>(), res, 1);
        return res;
    }

    public void backtrack(int n, int k, List<Integer> temp, List<List<Integer>> res, int start) {

        //递归结束条件
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        //从n个数里选一个
        for (int i = start; i<=n; i++) {
            temp.add(i);
            //递归选第二个
            backtrack(n, k, temp, res, start+1);
            //当前递归，回溯到上一层
            temp.remove(temp.size() - 1);
        }
    }
}
