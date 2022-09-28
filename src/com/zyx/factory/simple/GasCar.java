package com.zyx.factory.simple;

public class GasCar implements Car{

    @Override
    public void getName() {
        System.out.println("我是汽油车");
    }
}
