package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 题目：实现三个线程循环打印ABC
 * 思路：原子类
 *
 * @author ：stone
 * @date ：Created in 2020/3/23 16:44
 */
public class PrintABCCycle {
    private AtomicInteger sycValue = new AtomicInteger(0); //打印的值使用原子类对象，并设置为0

    private static final int MAX_SYC_VALUE = 3 * 10;

    public static void main(String[] args) {
        PrintABCCycle example = new PrintABCCycle();
        ExecutorService service = Executors.newFixedThreadPool(3);//创建线程池，线程数量为3

        service.execute(example.new RunnableA()); //提交执行线程
        service.execute(example.new RunnableB());
        service.execute(example.new RunnableC());

        service.shutdown(); //线程结束后中断
    }

    private class RunnableA implements Runnable { ///实现Runnable
        public void run() {
            //循环打印
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 0) {
                    System.out.println(String.format("第%d遍", sycValue.get() / 3 + 1));
                    System.out.println("A");
                    sycValue.getAndIncrement();
                }
            }
        }
    }

    private class RunnableB implements Runnable {
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 1) {
                    System.out.println("B");
                    sycValue.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {

        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 2) {
                    System.out.println("C");
                    //System.out.println();
                    sycValue.getAndIncrement();
                }
            }

        }
    }
}
