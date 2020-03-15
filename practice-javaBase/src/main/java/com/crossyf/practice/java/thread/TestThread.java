package com.crossyf.practice.java.thread;

/**
 * @author Created by crossyf.
 * @date 2020/2/25
 * 功能:
 */
public class TestThread{


    public static synchronized void test() {
        String string = "dkjfsl";
        try {
            string.wait(10000);
            System.out.println("测试方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadA());
        threadA.setName("AAA");

        Thread threadB = new Thread(new ThreadA());
        threadB.setName("BBB");

        threadA.start();
        threadB.start();
    }
}

