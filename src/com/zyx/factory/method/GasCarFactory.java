package com.zyx.factory.method;

public class GasCarFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new GasCar();
    }
}
