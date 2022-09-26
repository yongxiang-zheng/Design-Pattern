package com.zyx.singleton;

// 线程不安全懒汉式
public class Lazy01 {
    // 私有构造器
    private Lazy01(){
    }
    // 初始化对象
    private static Lazy01 lazy;
    // 静态公共方法创建对象
    public static Lazy01 getLazy() {
        if(lazy == null){
            lazy = new Lazy01();
        }
        return lazy;
    }
    // 测试
    public static void main(String[] args) {
        System.out.println(Lazy01.getLazy().hashCode());
        System.out.println(Lazy01.getLazy().hashCode());
    }
}
