package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：39. Combination Sum
 * [2,3,6,7], target = 7  找到和为target的所有子数组 [2,2,3] [7]
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/15 16:45
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);//12
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }


     /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        Arrays.sort(nums);
        backTrack1(target, res, new ArrayList<>(), nums, 0);
        return res;
    }


    public void backTrack1(int target, List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (target < 0) return;
        if (target == 0) res.add(new ArrayList<>(temp));

        for (int i=start; i<nums.length; i++) {
            if (target - nums[i] < 0) break;  //剪枝
            temp.add(nums[i]);
            backTrack1(target-nums[i], res, temp, nums, i);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }
}


