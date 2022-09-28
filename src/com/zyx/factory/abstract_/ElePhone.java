package com.zyx.factory.abstract_;

public class ElePhone implements Phone{
    @Override
    public void call() {
        System.out.println("ElePhone Call!");
    }
}
