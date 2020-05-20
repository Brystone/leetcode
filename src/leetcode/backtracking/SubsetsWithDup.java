package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName SubsetsWithDup
 * @Description 90. 子集 II  包含重复元素的整数数组 nums
 * @date 2020/5/13 18:31
 */
public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }


    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (res.contains(temp))  return;
        res.add(new ArrayList<>(temp)); //第一次执行时temp为空，添加到res中
        //return; 无需递归截止条件，循环结束即可

        for (int i=start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; //对同一层进行剪枝
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }
}
