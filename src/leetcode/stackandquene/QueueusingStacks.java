package leetcode.stackandquene;
/*
232. Implement Queue using Stacks (Easy)
用两个栈实现队列，
out方法就是第二个栈存入第一个栈内的结点，然后出栈就是队列元素出队的顺序
队列的进队顺序就是栈的进栈顺序
 */

import java.util.Stack;

public class QueueusingStacks {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> OutStack = new Stack<>();

    /** Initialize your data structure here. */
    public QueueusingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        out();
        return OutStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        out(); //in元素入out栈
        return OutStack.peek();
    }

    /**
     * 核心操作：in栈向out栈压入数据，1. in栈需要全部压入 2. 只有out栈为空才能压入
     */
    public void out() {
        if (OutStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                OutStack.push(inStack.pop());
            }
        }
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && OutStack.isEmpty();
    }
}
