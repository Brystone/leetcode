package jianzhioffer;

import sun.security.jca.GetInstance;

import java.security.Signature;

/**
 * 题目：实现单例模式
 * 思路：
 * @author ：stone
 * @date ：Created in 2020/3/5 15:30
 */
public class Singleton {
    /**
     *  饿汉模式
     * 1.构造函数私有化
     * 2. new一个类唯一的对象
     * 3. 实现public方法返回创建的对象
     */
    private static Singleton singleton = new Singleton();
    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
/**
 * 懒汉模式
 * 实例为空时才被new出来
 */
class Singleton2 {
    private static Singleton2 singleton2;
    private Singleton2() {}
    public static Singleton2 getInstance2(Singleton2 singleton2) {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

/**
 * 懒汉模式 线程安全形式 效率低
 */
class Singleton3 {
    private static Singleton3 singleton3;
    private Singleton3() {}
    public static synchronized Singleton3 getInstance3(Singleton3 singleton3) {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}


/**
 *懒汉模式 双重校验锁
 */
class Singleton4 {
    private static Singleton4 singleton4;
    private Singleton4() {}
    //多线程环境下，如果多个线程执行判断会创建多个对象。这时候对对象加同步锁，实现只创建一个对象
    public static Singleton4 getInstance4(Singleton4 singleton4) {
        if (singleton4 == null) { //第一次获取对象时加锁
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}

