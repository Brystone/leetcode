package leetcode.Multithreading.consumerProducter;

import java.util.concurrent.BlockingQueue;

/**
 * 题目：
 * 思路：
 *生产者
 * @author ：stone
 * @date ：Created in 2020/4/9 17:35
 */
public class Producer implements Runnable  {
    BlockingQueue<String> queue; //生产者队列

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String tmp = "Product:"+ Thread.currentThread().getName(); //商品1、2...
            queue.put(tmp);  //当生产队列满时，自动阻塞进入等待状态，直到队列有空位置
            System.out.println("i have made a product:" + Thread.currentThread().getName()); //输出生产信息
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
