# 装饰者模式 🐂🍺
## 装饰者模式目的
    优点是：在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
    缺点是：装饰器模式会增加许多子类，过度使用会增加程序得复杂性
## 代码实现
```java
// 接口
package com.zyx.decorator;

public interface Toy {
    void sing();
    void dance();
}
```
```java
// 第一代玩具 - 实现类
package com.zyx.decorator;

public class FirstToy implements Toy{
    public void sing(){
        System.out.println("第一代玩具-唱歌");
    }
    public void dance(){
        System.out.println("第一代玩具-跳舞");
    }

}
```
```java
// 第二代玩具 - 组合第一代玩具，扩展第二代的方法
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
```
```java
// 测试类
package com.zyx.decorator;

public class MyTest {
    public static void main(String[] args) {
        FirstToy firstToy = new FirstToy();
        firstToy.dance();
        firstToy.sing();
        System.out.println("===============");
        SecondToy secondToy = new SecondToy(firstToy);
        secondToy.dance();
        secondToy.sing();
        secondToy.sweep();
    }
}
```
Output:

![img.png](static/img.png)
