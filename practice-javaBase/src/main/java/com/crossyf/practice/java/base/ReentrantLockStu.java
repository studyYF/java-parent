package com.crossyf.practice.java.base;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by YangFan.
 * @date 2020/1/22
 * 功能: 可公平性，可重入，可中断interrupt
 */
public class ReentrantLockStu extends Thread {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;


    public ReentrantLockStu(String name) {
        super.setName(name);
    }

    @Override
    public void run() {

        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                System.out.println(this.getName() + "" + i);
                i ++;
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockStu reentrantLockStu1 = new ReentrantLockStu("thread1");
        ReentrantLockStu reentrantLockStu2 = new ReentrantLockStu("thread2");

        reentrantLockStu1.start();
        reentrantLockStu2.start();
        reentrantLockStu1.join();
        reentrantLockStu2.join();
        System.out.println(i);
    }
}
