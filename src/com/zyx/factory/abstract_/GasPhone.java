package com.zyx.factory.abstract_;

public class GasPhone implements Phone{
    @Override
    public void call() {
        System.out.println("GasPhone Call!");
    }
}
