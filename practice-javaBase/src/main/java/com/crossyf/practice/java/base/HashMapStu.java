package com.crossyf.practice.java.base;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by YangFan.
 * @date 2020/1/14
 * 功能:
 */
public class HashMapStu {



    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public HashMapStu(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HashMapStu) {
            HashMapStu stu = (HashMapStu)obj;
            return stu.version == version;
        }
        return false;
    }

    @Override
    public int hashCode() {
        byte result = 1;
        Integer data = this.getVersion();
        return result * 59 + (data == null?43:data.hashCode());
    }

//    public static void main(String[] args) {
////
////        Map<String, Object> hashMap = new HashMap<>();
////        hashMap.put("1","aaa");
////        hashMap.put("2","bbb");
////        hashMap.put("3",true);
////        hashMap.put("4",2);
////        for (String s : hashMap.keySet()) {
////            System.out.println(s);
////        }
////        System.out.println(hashMap.entrySet());
////        for (Map.Entry<String, Object> stringObjectEntry : hashMap.entrySet()) {
////            System.out.println("key=" + stringObjectEntry.getKey());
////            System.out.println("value=" + stringObjectEntry.getValue());
////        }
////
////
////        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
////        concurrentHashMap.put("1","2");
////        concurrentHashMap.put("3","2");
////        System.out.println(concurrentHashMap.size());
//
//
//        HashMapStu mapStu1 = new HashMapStu(1);
//        Map<Object, String> map = new HashMap<>(2);
//        map.put(mapStu1,"22");
//
//        HashMapStu mapStu2 = new HashMapStu(1);
//        String value = map.get(mapStu2);
//        System.out.println(value);
//        System.out.println(mapStu1.hashCode());
//        System.out.println(mapStu2.hashCode());
//
//        Iterator iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry)iterator.next();
//            Object key = entry.getKey();
//            Object value1 = entry.getValue();
//            System.out.println("key ===" +key);
//            System.out.println("value === " + value1);
//        }
//
//
//
//
//
//    }

    public static void main(String[] args) {
        Map<String, Object> hashMap = new HashMap<>();

    }
}
