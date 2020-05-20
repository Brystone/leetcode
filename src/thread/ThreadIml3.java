package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/10 9:37
 */
public class ThreadIml3 {
    public static void main(String[] args) {
        ThreadDemo3 t3 = new ThreadDemo3();
        FutureTask ft = new FutureTask(t3);
        new Thread(ft).start();
        try {
            Object  i = ft.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class ThreadDemo3 implements Callable<Integer> {
        @Override
        public Integer call() {
            int i = 0;
                for (; i < 100; i++)
                    i += 1;
                return i;
        }
    }
}