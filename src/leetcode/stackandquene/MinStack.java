package leetcode.stackandquene;

import java.util.Stack;

/*
155. Min Stack E
获取栈中最小值
思路；借助辅助空间，用一个栈存储当前的最小值，返回最小值栈的栈顶就可得到最小值
 */

public class MinStack {
    Stack<Integer> stack; //辅助栈
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }


    //最小的入栈
    public void push(int x) {
        stack.push(x);
        min = Math.min(x, min); //将第一个元素设为最小值，通过比较的方式
        minStack.push(min);
    }

    //删除栈顶元素，栈和辅助栈都要删除，当获取最小值时，实现同步；这里当辅助栈为空时，最小值要回到初始值
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
