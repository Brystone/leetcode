package jianzhioffer.StackAndQuene;

import java.util.LinkedList;
import java.util.Stack;

public class IsPopOrder {
    public static boolean isPopOrder(int[] pushed, int[] poped) {
        if (pushed == null || poped == null || pushed.length == 0 || poped.length == 0) {
            return false;
        }
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i < pushed.length;i++) {
            // 按照入栈序列依次压入辅助栈中
            stack.push(pushed[i]);
            // 每入栈一次和出栈序列比较，如果栈顶和当前出栈元     素相同，则弹出同时当前弹出元素指针前移；
            // 如果下一个栈顶元素还和当前弹出元素相同，继续弹出
            while (!stack.isEmpty() && stack.peek() == poped[j]) {

                stack.pop();
                j++;
            }
        }
        // 如果出栈顺序正确，模拟一次进出栈后，辅助栈应该为空。不为空说明序列不正确
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 2, 1};
        boolean res = isPopOrder(push, pop);
        System.out.println(res);
    }
}
