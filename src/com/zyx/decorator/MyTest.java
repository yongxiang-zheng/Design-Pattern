package com.zyx.decorator;

public class MyTest {
    public static void main(String[] args) {
        FirstToy firstToy = new FirstToy();
        firstToy.dance();
        firstToy.sing();
        System.out.println("===============");
        SecondToy secondToy = new SecondToy(firstToy);
        secondToy.dance();
        secondToy.sing();
        secondToy.sweep();
    }
}
