package com.crossyf.practice.java.base.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by crossyf.
 * @date 2020/3/13
 * 功能:
 */
public class Provider {
    private Lock lock = new ReentrantLock();
    private Condition emptyCondition = lock.newCondition();
    private Condition fullCondition = lock.newCondition();
    private int index;
    private Object[] items;

    public Provider(int cap) {
        items = new Object[cap];
    }

    public boolean put(String value) {
        if ((index + 1) == items.length) {
            return false;
        }
        return false;
    }
}
