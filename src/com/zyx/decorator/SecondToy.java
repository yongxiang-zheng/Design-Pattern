package com.zyx.decorator;

public class SecondToy implements Toy{
    private  FirstToy firstToy;

    public SecondToy(FirstToy firstToy) {
        this.firstToy = firstToy;
    }

    public void sing(){
        firstToy.sing();
    }

    public void dance(){
        firstToy.dance();
    }

    public void sweep(){
        System.out.println("第二代玩具-打扫卫生");
    }
}
