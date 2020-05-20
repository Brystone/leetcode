package jianzhioffer.StackAndQuene;

import java.util.Deque;
import java.util.LinkedList;

public class QueneWithMax {
    /*
    自己定义队列，实现max函数得到队列里的最大值
     */
    private Deque<Integer> dataDeque = new LinkedList<>();
    private Deque<Integer> maxDeque = new LinkedList<>();

    //入队列
    public void offer(int number) {
        dataDeque.offerLast(number);
        if (maxDeque.isEmpty() || number > maxDeque.peekFirst()) {  //当前队列的最大值
            maxDeque.offerFirst(number);
        } else {
            maxDeque.offerFirst(maxDeque.peekFirst());
        }
    }

    //元素出队列需要判断队列是否为空
    public void poll() {
        if (dataDeque.isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        dataDeque.pollFirst();
        maxDeque.pollFirst();
    }

    public int max() {
        if (dataDeque.isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        return maxDeque.peekFirst();
    }
}

class Test {
    public static void main(String[] args) {
        QueneWithMax qwm = new QueneWithMax();
         qwm.offer(2);
        qwm.offer(3);
        qwm.offer(4);
        qwm.offer(5);
        qwm.offer(6);
        int res = qwm.max();
        System.out.println(res);
    }
}