package com.zyx.factory.method;

public class EleCarFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new EleCar();
    }
}
