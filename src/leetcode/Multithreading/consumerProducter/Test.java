package leetcode.Multithreading.consumerProducter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/9 17:44
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        for (int i = 0; i < 5; i++) {
            new Thread(producer, "Producer" + (i+1)).start(); //开启生产者和消费者线程，
            new Thread(consumer, "Consumer" + (i+1)).start();
        }
    }
}
