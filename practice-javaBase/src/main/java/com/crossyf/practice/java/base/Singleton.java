package com.crossyf.practice.java.base;

/**
 * @author Created by YangFan.
 * @date 2020/1/21
 * 功能: 实例单例
 */
public class Singleton {

    /**
     * volatile可以禁止JVM对指令重排，保证不同线程获取uniqueInstance实例都是同一个实例
     * uniqueInstance = new Singleton() 方法可以分成3步骤
     * 1.分配内存，2.初始化参数、3.将变量指向分配的内存
     * JVM对指令进行重排后可能导致，先执行1和3，后执行2，在多线程的情况下，可能获取到一个还没有初始化的对象。
     */
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }


    public static Singleton getUniqueInstance() {

        if (uniqueInstance == null) {

            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }


}
