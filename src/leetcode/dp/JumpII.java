package leetcode.dp;

/**
 * @author stone
 * @version 1.0
 * @ClassName JumpII
 * @Description  45. 跳跃游戏 II H
 * @date 2020/5/7 12:26
 */
public class JumpII {
    public int jumpII(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int jump = 0;

        for (int i=0; i<nums.length; i++) {
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if (i == end) {
                end = maxPosition;
                jump++;
            }
        }
        return jump;
    }
}
