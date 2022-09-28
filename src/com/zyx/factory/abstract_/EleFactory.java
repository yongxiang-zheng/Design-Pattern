package com.zyx.factory.abstract_;

public class EleFactory implements AbstractFactory {
    @Override
    public Car getCar() {
        return new EleCar();
    }

    @Override
    public Phone getPhone() {
        return new ElePhone();
    }
}
