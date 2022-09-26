package com.zyx.singleton;

public class Lazy03 {
    private static Lazy03 lazy03;

    private Lazy03(){

    }

    public static Lazy03 getLazy03() {
        if(lazy03 == null){
            synchronized (Lazy03.class){
                lazy03 = new Lazy03();
            }
        }
        return lazy03;
    }

    public static void main(String[] args) {
        System.out.println(Lazy03.getLazy03().hashCode());
        System.out.println(Lazy03.getLazy03().hashCode());
    }
}
