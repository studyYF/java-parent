package com.crossyf.practice.java.base.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by crossyf.
 * @date 2020/3/11
 * 功能:
 */
public class AqsDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
