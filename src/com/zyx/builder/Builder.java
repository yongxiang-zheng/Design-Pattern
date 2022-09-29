package com.zyx.builder;

public interface Builder {
    void buildBasic();
    void buildWall();
    void buildRoof();
    Product makeProduct();
}
