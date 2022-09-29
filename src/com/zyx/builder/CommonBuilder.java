package com.zyx.builder;

// 产品的建造
public class CommonBuilder implements Builder{
    Product product = new Product();

    @Override
    public void buildBasic() {
        product.setBasic("Common Basic");
    }

    @Override
    public void buildWall() {
        product.setWall("Common Wall");
    }

    @Override
    public void buildRoof() {
        product.setRoof("Common Roof");
    }

    @Override
    public Product makeProduct() {
        return product;
    }
}
