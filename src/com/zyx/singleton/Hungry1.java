package com.zyx.singleton;

// 静态常量饿汉式
public class Hungry1 {
    // 私有构造器
    private Hungry1(){
    }
    // 内部创建对象
    private static final Hungry1 hungry = new Hungry1();

    // 提供公用静态方法
    public static Hungry1 getHungry() {
        return hungry;
    }
    // 测试
    public static void main(String[] args) {
        System.out.println(Hungry1.getHungry().hashCode());
        System.out.println(Hungry1.getHungry().hashCode());
    }
}
