package com.crossyf.practice.java.base;

/**
 * @author Created by crossyf.
 * @date 2020/2/27
 * 功能: StringBuffer 和 StringBuilder的区别
 * 总结：StringBuffer是线程安全的
 */
public class StringBufferTest {

    public static void main(String[] args) {
        //extends AbstractStringBuilder
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("this");
        stringBuffer.append("is");
        stringBuffer.append(1);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.charAt(2));
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.reverse().toString());
        System.out.println("--------");
        //extends AbstractStringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("you").append("are").append(18);
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.charAt(2));
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.reverse().toString());


        String a = "aaa";
        System.out.println(a);
        a = "bbb";
        System.out.println(a);
    }
}
