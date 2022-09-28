package com.zyx.factory.method;

public class MyTest {
    public static void main(String[] args) {
        Car car1 = new EleCarFactory().getCar();
        Car car2 = new GasCarFactory().getCar();
        car1.getName();
        car2.getName();
    }
}
