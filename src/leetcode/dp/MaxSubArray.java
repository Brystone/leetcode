package leetcode.dp;

/**
 * 题目：53. 最大子序和
 * 思路：卡登算法，遍历整个数组，记录以arr[i]为结尾的最大子序列和
 *      状态转移方程 sum[i] = max {sum[i-1] + arr[i], arr[i]}
 *
 * @author ：stone
 * @date ：Created in 2020/3/22 17:33
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        /*
        int ans = nums[0];

        int curSum = nums[0]; //以i结尾的子序列的最大和
        for (int i=1; i<nums.length; i++) {
            curSum = Math.max(curSum, 0) + nums[i]; //取决于前一个和 dp[i] = max(dp[i-1], 0) + nums[i]; 加上负数会使和变小，则舍去
            ans = Math.max(ans, curSum);
        }
        return ans;*/
        int max_ending_cur = nums[0];
        int maxsum = nums[0];

        for (int i=1; i<nums.length; i++) {
            max_ending_cur = Math.max(nums[i], nums[i] + max_ending_cur);
            maxsum = Math.max(max_ending_cur, maxsum);
        }
        return maxsum;
    }
}
