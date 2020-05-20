package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName CombinationSum2
 * @Description 40 M
 * @date 2020/5/12 16:01
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || candidates == null) return res;
        Arrays.sort(candidates);
        backTrack2(target, res, new ArrayList<>(), candidates, 0);
        return res;
    }
    public void backTrack2(int target, List<List<Integer>> res, List<Integer> temp, int[] nums,   int start) {
        if (target < 0) return;
        if (target == 0) res.add(new ArrayList<>(temp));

        for (int i=start; i<nums.length; i++) {
            if (target - nums[i] < 0) break;
            if ( i > start && nums[i] == nums[i-1]) continue; //
            temp.add(nums[i]);
            backTrack2(target-nums[i], res, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
