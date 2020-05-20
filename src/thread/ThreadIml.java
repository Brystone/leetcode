package thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/9 23:04
 */
public class ThreadIml {
    public static void main(String[] args) {
        Thread thread = new ThreadDemo();
        thread.setName("线程1");
        thread.start();
        //ThreadPoolExecutor te = new ThreadPoolExecutor()
    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
