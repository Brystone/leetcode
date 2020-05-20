package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName PermuteUnique
 * @Description 47. 全排列 II M
 * @date 2020/5/14 20:46
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), visited);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            //return;
        }
        for(int i=0; i<nums.length; i++) {
            //判断集合中是否存在此元素
            if (visited[i] == true) continue;
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == true) continue; //去重
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums, res, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
