package leetcode.bitopration;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/20 17:57
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;
        diff &= -diff;  // 得到最右一位不为0的位
        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) ret[0] ^= num;
            else ret[1] ^= num;
        }
        return ret;
    }
}
