package leetcode.stackandquene;

import java.util.Stack;

/**
 * 题目：739. Daily T
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/13 11:11
 */
public class DailyTemperatures {
    public int[] dailyT(int[] T) {
    //用一个栈存储数组元素，这里要计算距离，所以存储数组索引
        Stack<Integer> stack = new Stack<>();
        //用数组存储结果
        int[] res = new int[T.length];
        //遍历数组让元素进栈
        for (int i=0; i<T.length; i++) {
            //如果栈不为空并且当前元素值大于栈顶元素 就弹出栈顶计算出距离，这里是不停地和栈里下个元素比较就是和当前位置前面的数比较
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
