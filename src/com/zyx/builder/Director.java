package com.zyx.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product getProduct() {
        builder.buildBasic();
        builder.buildWall();
        builder.buildRoof();
        return builder.makeProduct();
    }
}
