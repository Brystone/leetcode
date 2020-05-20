package newcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueneConvert {

    /*
    两个栈实现一个队列:
    push和pop栈，push栈所有元素都压入pop栈 然后pop栈出栈
     */

    //内部类，可以作为一个普通类使用
    public static class TwoStackQuene {
        //建立栈结构用泛型
        private Stack<Integer> stackPop; //私有的只能在本类中使用
        private Stack<Integer> stackPush;

        //无参构造方法初始化
        public TwoStackQuene() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        //元素压栈 静态类名调用 对象也可以调用
        public void push(int newNum) {
            stackPush.push(newNum);
        }


        //将元素压入pop栈,压入之前要确定 pop 栈内没有元素,元素出栈 从而实现队列先进先出
        public int poll() {
            //如果两个栈都为空，则抛出空数组异常
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Quene is empty");
            } else if(stackPop.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("stack is empty");
            } else if (stackPop.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }
    }

    /*
    两个队列实现栈
       data队列存放数据，help队列辅助元素出队列
       data队列中还剩一个 则不再出队列
     */

    public static class TwoQueneStack {
        Queue<Integer> data;
        Queue<Integer> help;

        public TwoQueneStack() {
            data = new LinkedList<Integer>(); //队列可以用双向链表实现
            help = new LinkedList<Integer>();
        }

        //入队列操作
        public void push(int newNum) {
            data.add(newNum);
        }

        //出队列操作
        public int poll() {
            //队列为空
            if (data.isEmpty()) {
                throw new RuntimeException("Quene is empty");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = help.poll();
            swap();
            return res;
        }

        //将两个交换
        public void swap() {
            Queue<Integer> temp = data;
            data = help;
            help = data;
        }
        //返回栈顶元素但不出栈
        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Quene is empty");
            }
             while (data.size() != 1) {
                 help.add(data.poll());
             }
             int res = data.poll();
             swap();
             return data.peek();
        }
    }
}

