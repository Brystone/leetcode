package leetcode.dp;

/**
 * @author stone
 * @version 1.0
 * @ClassName Jump
 * @Description 55. 跳跃游戏
 * @date 2020/5/6 11:53
 */
public class Jump {
    /**
     *
     * @param nums
     * @return
     */
    public boolean jump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前位置大于能跳的最远位置，则返回false
            if (i > k) return false;
            //以每个格子为起点开始跳，更新能跳的最大距离
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
