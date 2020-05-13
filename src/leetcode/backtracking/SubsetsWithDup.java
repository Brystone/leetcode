package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName SubsetsWithDup
 * @Description
 * @date 2020/5/13 18:31
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (res.contains(temp))  return;
        res.add(new ArrayList<>(temp)); //第一次执行时temp为空，添加到res中
        //return; 无需递归截止条件，循环结束即可

        for (int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            backTrack(res, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
