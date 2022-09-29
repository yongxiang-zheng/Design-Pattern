package com.zyx.builder;

public class MyTest {
    public static void main(String[] args) {
        CommonBuilder commonBuilder = new CommonBuilder();
        Director director = new Director(commonBuilder);
        System.out.println(director.getProduct());
    }
}
