package com.crossyf.practice.java.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by YangFan.
 * @date 2020/1/19
 * 功能: ConcurrentHashMap 学习
 */
public class ConcurrentHashMapStu {

    public static void main(String[] args) {
//        Map map = Collections.synchronizedMap(new HashMap<>(1));
//        map.put("1","aaa");
//        System.out.println(map.keySet());

        List<String> arrayList = new ArrayList<>(3);
        System.out.println(arrayList.size());
        arrayList.set(2,"1");
    }


}
