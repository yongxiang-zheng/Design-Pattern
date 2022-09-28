package com.zyx.factory.abstract_;

public class MyTest {
    public static void main(String[] args) {
        EleFactory eleFactory = new EleFactory();
        eleFactory.getCar().getName();
        eleFactory.getPhone().call();

        GasFactory gasFactory = new GasFactory();
        gasFactory.getCar().getName();
        gasFactory.getPhone().call();
    }
}
