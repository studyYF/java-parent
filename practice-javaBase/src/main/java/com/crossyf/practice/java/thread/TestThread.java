package com.crossyf.practice.java.thread;

/**
 * @author Created by crossyf.
 * @date 2020/2/25
 * 功能:
 */
public class TestThread implements Runnable {


    @Override
    public void run() {
        System.out.println("我是线程b");
    }

    public static void main(String[] args) {
        Thread testThread = new Thread(new TestThread());
        testThread.start();

        Thread threada = new Thread(new ThreadA());
        threada.start();
    }
}

