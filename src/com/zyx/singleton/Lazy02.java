package com.zyx.singleton;

// 线程安全懒汉式
public class Lazy02 {
    private static Lazy02 lazy02;

    private Lazy02(){

    }

    public synchronized static Lazy02 getLazy02() {
        if(lazy02 == null){
            lazy02 = new Lazy02();
        }
        return lazy02;
    }

    public static void main(String[] args) {
        System.out.println(Lazy02.getLazy02().hashCode());
        System.out.println(Lazy02.getLazy02().hashCode());
    }
}
