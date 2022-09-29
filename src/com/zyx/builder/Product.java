package com.zyx.builder;

// 产品的表示
public class Product {
    private String wall;
    private String basic;
    private String roof;

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "Product{" +
                "wall='" + wall + '\'' +
                ", basic='" + basic + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
