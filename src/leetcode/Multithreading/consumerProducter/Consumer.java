package leetcode.Multithreading.consumerProducter;
import java.util.concurrent.BlockingQueue;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/9 17:41
 */
public class Consumer implements Runnable{
    BlockingQueue<String> queue;
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String tmp = queue.take(); //从队列中拿出数据， 队列中没有数据就自动挂起，直到有数据
            System.out.println(tmp); //输出消费信息
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
