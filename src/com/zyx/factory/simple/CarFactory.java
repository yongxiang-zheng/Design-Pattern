package com.zyx.factory.simple;

import java.util.Objects;

public class CarFactory {
    public static Car getCar(String name){
        if(Objects.equals(name, "Gas")){
            return new GasCar();
        }else if(Objects.equals(name, "Ele")){
            return new EleCar();
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("Gas");
        Car car2 = CarFactory.getCar("Ele");
        car1.getName();
        car2.getName();

    }
}
