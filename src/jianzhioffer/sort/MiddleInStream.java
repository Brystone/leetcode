package jianzhioffer.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MiddleInStream {
    private PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    int count = 0;

    public void Insert(Integer num) {
        if (count == 0) {
            maxPQ.offer(num);
        } else if ((count&1) == 1) { // 数据个数为奇数插入最小堆
            if (num < maxPQ.peek()) { // 插入值小于最大堆的堆顶
                minPQ.offer(maxPQ.poll()); //最大堆对顶插入最小堆
                maxPQ.offer(num); //将数据插入最大堆
            } else {
                minPQ.offer(num);
            }
        } else if ((count & 1) == 0) { //数据个数为偶数插入最大堆
            if (num > minPQ.peek()) {  //num比最小堆对顶大
                maxPQ.offer(minPQ.poll());
                minPQ.offer(num);
            } else {
                maxPQ.offer(num);
            }
        }
        count++; //完成一次操作，计数器+1
    }

    public Double getMidia() {
        if ((count & 1) == 1) {
            return Double.valueOf(maxPQ.peek()); //数据流个数为奇数，中位数在最大堆中
        }
        return Double.valueOf((maxPQ.peek() + minPQ.peek())) / 2; // 偶数，两个堆顶求均值
    }
}
