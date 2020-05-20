package jianzhioffer.StackAndQuene;

import java.util.Stack;

public class Get_Min_Stack {
    //先建立两个栈
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    //初始化栈
    public Get_Min_Stack() {
       this.stackData = new Stack<Integer>();
       this.stackMin = new Stack<Integer>();
    }
    //入栈操作
    public void push(int newNum) { //变量名字第二个字母大写 | 静态只能引用静态
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) { //获取栈顶元素
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackMin.isEmpty()) {
            System.out.println("The stack is null");
        }
        //两个栈都弹出
        return this.stackMin.pop();
        //return this.stackData.pop();
    }

    //返回栈顶元素
    public int getMin() {
        if (this.stackMin.isEmpty()) {
            System.out.println("The stack is null");
        }
        return stackMin.peek();
    }

//测试 一系列的入栈和出栈操作
    public static void main(String[] args) {
        Get_Min_Stack stack = new Get_Min_Stack();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        int a = stack.pop();
        System.out.println(a);
    }
}
