package leetcode.Multithreading;

/**
 * 题目：1114. 按序打印
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/9 17:18
 */
public class Foo {
    //1. 同步锁保证线程安全，计数器按序执行，提交结果表明 时空消耗较大
    private Object object = new Object();
    private int flag = 0;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            //手动调用,使线程休眠
            while (flag != 0) object.wait();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            //设置flag值，使下一个线程执行
            flag = 1;
            //唤醒其他所有等待线程
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) object.wait();
            printSecond.run();
            //设置flag值，使下一个线程执行
            flag = 2;
            //唤醒其他所有等待线程
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) object.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 0;
            object.notifyAll();
        }
    }
}
