package com.crossyf.practice.java.base;

/**
 * @author Created by crossyf.
 * @date 2020/2/27
 * 功能:
 */
public class StaticClass {

    public static int a = 3;

    private int b;

    public static void main(String[] args) {
        StaticClass staticClass1 = new StaticClass();
        staticClass1.setB(5);
        StaticClass.setA(2);
        System.out.println("a1的值：" + staticClass1.getB());
        System.out.println("b的值：" + StaticClass.getA());


        StaticClass staticClass2 = new StaticClass();
        staticClass2.setB(6);
//        StaticClass.setA(3);
        System.out.println("a2的值：" + staticClass2.getB());
        System.out.println("b的值：" + StaticClass.getA());


    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        StaticClass.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
