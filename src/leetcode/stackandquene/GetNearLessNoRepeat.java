package leetcode.stackandquene;

import java.util.Queue;
import java.util.Stack;

/**
 * 题目：单调栈 arr={3，4，1，5，6，2，7} 找出无重复数组中的每一个位置离a[i]最近，并且比a[i]小
 * 思路：https://weread.qq.com/web/reader/1be32b907184877a1be90a2kaab325601eaab3238922e53
 *
 * @author ：stone
 * @date ：Created in 2020/4/6 20:49
 */
public class GetNearLessNoRepeat {
    public static int[][] getNearLessNoRepeat(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];

        for (int i= 0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;// 左边比弹出元素小的
                res[popIndex][1] = i; //右边比弹出元素小的索引
            }
            stack.push(i);
        }
        //遍历完以后将栈中剩下的结点弹出
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 1, 5, 6, 2, 7};
        int[][] res = getNearLessNoRepeat(arr);
        for (int i=0; i<res.length; i++) {
            for (int j=0; j<res[0].length; j++) {
                System.out.println();
            }
        }
    }
}
