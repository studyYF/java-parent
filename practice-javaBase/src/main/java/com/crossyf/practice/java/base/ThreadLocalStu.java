package com.crossyf.practice.java.base;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author Created by YangFan.
 * @date 2020/1/22
 * 功能: threadLocal学习
 */
public class ThreadLocalStu implements Runnable {


    private static final ThreadLocal<SimpleDateFormat> formatter
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run() {
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "default formatter ="
         + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "formatter ="
                + formatter.get().toPattern());

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadLocalStu threadLocalStu = new ThreadLocalStu();
            Thread thread = new Thread(threadLocalStu,i + "");
            thread.start();
        }
    }
}








