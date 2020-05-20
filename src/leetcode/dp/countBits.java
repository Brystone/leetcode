package leetcode.dp;

/**
 * 题目：338. Counting Bits  计算范围内每个数字1的个数
 *       5 --> [0, 1, 1, 2, 1, 2]
 * 思路：分为奇偶，和1相与来判断，偶数二进制末位为0，1的个数相当于右一一位；奇数就比前面的偶数多一个1
 * 偶数：
 * num:      101010101010
 * num >> 1: 10101010101
 *奇数：
 * num:      101010101011
 * num >> 1: 101010101010 + 1
 *
 * @author ：stone
 * @date ：Created in 2020/3/11 11:14
 */
public class countBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        //如果一个数二进制最后一为0，那么向右移一位1的个数是相同
        //如果为1向右移动一位就要加上1的个数, 其实右移就是缩小范围到前面去找
        for (int i=0; i<num; i++) {
            res[i] =  res[i >> 1] + (i & 1);
        }
        return res;
    }
}
