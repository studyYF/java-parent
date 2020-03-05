package com.crossyf.practice.java.thread;

import com.crossyf.practice.java.base.Girl;
import com.crossyf.practice.java.base.keyword.Son;
import com.crossyf.practice.java.thread.Couser;

/**
 * @author Created by crossyf.
 * @date 2020/3/2
 * 功能:
 */
public class KeywordTest {

    public static void main(String[] args) {
        Son son = new Son();
        Girl girl = new Girl();
        Couser couser = new Couser();
        son.run("镇坪路");
        girl.run("曹杨路");
        couser.run("合作路");
    }

    public void add() {
        final int a = 3;
    }



}
