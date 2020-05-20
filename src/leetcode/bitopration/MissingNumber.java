package leetcode.bitopration;

/**
 * 题目：268. Missing Number [0, 1, 3] --> 2
 * 思路：技巧题
 * 异或运算   3 ^ 3 ^ 2, 不缺的话对应位置的数和索引异或是 0
 *
 * @author ：stone
 * @date ：Created in 2020/2/3 11:12
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i] ^ i;
        }
        return res;

    }
}
