package com.crossyf.practice.java.base;

import java.util.*;

/**
 * @author Created by crossyf.
 * @date 2020/2/27
 * 功能: ArrayList LinkedList Vector的关系
 * 总结: ArrayList 实现了List接口，读取速度快，删除和新增速度慢，主要是每次都要复制另个数组去操作
 * LinkedList 实现了List接口，存储的数据是双向链表，删除和新增快，查找慢，必须遍历所有数组
 * Vector 是ArrayList的线程安全实现
 */
public class ArrayTest {


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        Vector<String> strings1 = new Vector<>();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("ni");
        linkedList.add("hao");
        linkedList.add("a");
        linkedList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Iterator<String> iterator = linkedList.iterator();

        int a = 3;
        int b = 20;
        boolean flag = false;


        List<Object> list = Arrays.asList("22","33","4",3);

//        list.add(a);

//        list.add(flag);
        System.out.println(list.size());



    }
}
