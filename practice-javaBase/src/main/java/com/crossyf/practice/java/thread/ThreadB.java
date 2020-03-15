package com.crossyf.practice.java.thread;

/**
 * @author Created by crossyf.
 * @date 2020/3/5
 * 功能:
 */
public class ThreadB implements Runnable {
    @Override
    public void run() {
        System.out.println("我是线程" + Thread.currentThread().getName() + "， 我现在运行中");
        TestThread.test();

    }
}
