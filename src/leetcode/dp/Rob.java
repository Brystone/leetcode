package leetcode.dp;

/**
 * 题目：198. 打家劫舍
 * 思路：状态转移方法：f(i) = max(f(i-1), f(i-2)+A(i)) 偷 或者 不偷 f(i) 表示满足条件的情况下，偷到的最大金额
 *
 * @author ：stone
 * @date ：Created in 2020/4/4 21:45
 */
public class Rob {
    public int rob(int[] nums) {
        int sum = 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i=2; i<nums.length; i++) {
            sum = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return sum;
    }
}
