package com.crossyf.practice.java.thread;

/**
 * @author Created by crossyf.
 * @date 2020/2/27
 * 功能:
 */
public class ThreadA implements Runnable {
    @Override
    public void run() {

        System.out.println("我是线程" + Thread.currentThread().getName() + "， 我现在运行中");
        TestThread.test();

    }
}
