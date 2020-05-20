package leetcode.array;

import java.util.*;

/**
 * 题目：15. 三数之和
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/18 16:32
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null ||  nums.length < 3) return lists;
        //先对数组排序
        Arrays.sort(nums);
        //使用三个指针进行遍历相加，
        for (int i=0; i<nums.length; i++) {
            //第一个数大于0，不存在和等于0的子数组
            if (nums[i] > 0) break;
            if (i>0 && nums[i] == nums[i-1]) continue;//跳过即可
            int L = i+1;
            int R = nums.length-1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                //循环来到下一个如果和前一个数相等，那么跳过 因为会发生重复
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++; //跳过重复值，重复的值生成的数组会相同
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                if (sum < 0) L++;//向右找
                if (sum > 0) R++;//向左找
            }
        }
        return lists;
    }
}
