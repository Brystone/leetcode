package leetcode.bitopration;

/**
 * 题目：371. Sum of Two Integers 不使用+进行加法运算
 * 思路：进位 用 & >>1 来运算，相同为1，不同为 0
 *      1.循环条件为进位不为0，
 *      2.先计算进位
 *      3.异或得到位置不同的数的和
 *      4.进位左移
 * @author ：stone
 * @date ：Created in 2020/2/1 12:57
 */
public class getSum {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
