package leetcode.stackandquene;

import java.util.LinkedList;
import java.util.Queue;

/*
225. Implement Stack using Queues (Easy)
用队列实现栈  ----------    ----------
            5 4 3 2 1 --> 1 2 3 4 5
            ----------    ----------
 利用到队列在队首删除元素，在队尾添加元素
 对于栈的入栈操作，让元素先入队列， 然后删除队首元素并在队尾添加
 */
public class StackusingQueues {
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public StackusingQueues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        //遍历队列
        int size = queue.size();
        for (int i=0; i<size-1; i++) {
            queue.add(queue.poll()); //先出再加  poll()为空时，返回null
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.remove(); //删除队首
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
