package com.crossyf.practice.java.base.keyword;

/**
 * @author Created by crossyf.
 * @date 2020/3/2
 * 功能:
 */
public class Father implements Cloneable {

    protected void run(String road) {
        System.out.println("father在" + road + "上跑");
    }
}
