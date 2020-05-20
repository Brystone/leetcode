package leetcode.bitopration;

/**
 * 题目：136. Single Number 数组中每个数字出现两次，
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * 思路：使用异或运算，O^N = N 不同为1，相同为0
 *                  N^N = O
 *      0与任何数异或为数本身
 *
 * T = O(n)  S = O(1)
 * @author ：stone
 * @date ：Created in 2020/1/30 21:14
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sign = 0;
        for (int i=0; i<nums.length; i++) {
            sign ^= nums[i];
        }
        return sign;
    }
}
