package com.zyx.singleton;

public class Hungry2 {
    private static Hungry2 hungry2;

    private Hungry2(){

    }

    static {
        hungry2 = new Hungry2();
    }

    public static Hungry2 getHungry2() {
        return hungry2;
    }

    public static void main(String[] args) {
        Hungry2 hungry_01 = Hungry2.getHungry2();
        Hungry2 hungry_02 = Hungry2.getHungry2();
        System.out.println(hungry_01.hashCode());
        System.out.println(hungry_02.hashCode());
    }
}
