package leetcode.dp;

import java.util.Arrays;

/**
 * 题目： 300. 最长上升子序列 M
 * 思路：1. 暴力解法，T = O(n)
 *
 * @author ：stone
 * @date ：Created in 2020/4/25 15:42
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        /*
        动态数组 dp[i] 是第i个数字结尾的最长的子序列
        状态转移方程 dp[i] = max(dp[i], dp[j] + 1)
        找到前面的比nums[i]小的数的子序列，把nums[i]拼接上即可
         */
        int[] dp = new int[nums.length];
        //Arrays.fill(dp, 1); //填充工具 初始化为1
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
