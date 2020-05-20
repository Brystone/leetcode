package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 题目：46. Permutations
 * [1,2,3], 全排列
 * 思路：
 * @author ：stone
 * @date ：Created in 2020/3/14 21:36
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<>(), visited);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp,  boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            //判断集合中是否存在此元素
            //if (temp.contains(nums[i])) continue; O(n)
            if (visited[i] == true) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums, res, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        //System.out.println(permute(arr));
        //判断一个数是平方数
        System.out.println((int) Math.sqrt(24));
    }
}
