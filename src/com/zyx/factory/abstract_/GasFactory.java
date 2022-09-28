package com.zyx.factory.abstract_;

public class GasFactory implements AbstractFactory {
    @Override
    public Car getCar() {
        return new GasCar();
    }

    @Override
    public Phone getPhone() {
        return new GasPhone();
    }
}
