# 工厂模式 🐂🍺
1. 创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象
2. 好处：(1) 通过工厂模式可以把对象的创建和使用过程分割开来。比如说 Class A 想调用 Class B的方法，那么我们无需关心B是如何创建的，直接去工厂获取就行
        (2) 把对象创建的具体逻辑给隐藏起来了，交给工厂统一管理，这样不仅减少了代码量,以后如果想改代码的话，只需要改一处即可，也方便我们日常的维护
## 简单工厂模式
```java
// 公共接口
package com.zyx.factory.simple;

public interface Car {
    void getName();
}
```
```java
// 具体实现类实现接口 - 电动车
package com.zyx.factory.simple;

public class EleCar implements Car{

    @Override
    public void getName() {
        System.out.println("我是电动车");
    }
}

```
```java
// 具体实现类实现接口 - 汽油车
package com.zyx.factory.simple;

public class GasCar implements Car{

    @Override
    public void getName() {
        System.out.println("我是汽油车");
    }
}
```
```java
// 工厂类 - 用于创建对象
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
    // 通过传入参数来确定创建的对象的类型
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("Gas");
        Car car2 = CarFactory.getCar("Ele");
        car1.getName();
        car2.getName();

    }
}
```
缺点：不利于扩展，当需要增加产品类型时，需要修改原来的代码，使用工厂方法模式可以在不删减原本的代码基础上加上新的产品
## 工厂方法模式
```java
// 公共接口
package com.zyx.factory.simple;

public interface Car {
    void getName();
}
```
```java
// 具体实现类实现接口 - 电动车
package com.zyx.factory.simple;

public class EleCar implements Car{

    @Override
    public void getName() {
        System.out.println("我是电动车");
    }
}
```
```java
// 具体实现类实现接口 - 汽油车
package com.zyx.factory.simple;

public class GasCar implements Car{

    @Override
    public void getName() {
        System.out.println("我是汽油车");
    }
}
```
```java
// 工厂接口
package com.zyx.factory.method;

import java.util.Objects;

public interface CarFactory {
    Car getCar();
}
```
```java
// 专门生产电动车的工厂
package com.zyx.factory.method;

public class EleCarFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new EleCar();
    }
}
```
```java
// 专门生产汽油车的工厂
package com.zyx.factory.method;

public class GasCarFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new GasCar();
    }
}
```
```java
// 测试类
package com.zyx.factory.method;

public class MyTest {
    public static void main(String[] args) {
        Car car1 = new EleCarFactory().getCar();
        Car car2 = new GasCarFactory().getCar();
        car1.getName();
        car2.getName();
    }
}
```
缺点：代码扩展很多，每增加一个类就需要加入一个工厂类及产品类
## 抽象工厂模式
- 超级工厂-可以生产不同的产品，比如手机和电脑
```java
// Car接口 及 对应实现类
package com.zyx.factory.abstract_;

public interface Car {
        void getName();
}
// 电车实现类
class EleCar implements Car {

        @Override
        public void getName() {
                System.out.println("我是电动车");
        }
}
// 油车实现类
class GasCar implements Car {

        @Override
        public void getName() {
                System.out.println("我是汽油车");
        }
}
```

```java
// Phone接口 及 对应实现类
package com.zyx.factory.abstract_;

public interface Phone {
        void call();
}

// 电手机
class ElePhone implements Phone{
        @Override
        public void call() {
                System.out.println("ElePhone Call!");
        }
}
// 油手机
class GasPhone implements Phone{
        @Override
        public void call() {
                System.out.println("GasPhone Call!");
        }
}
```

```java
// 总工厂接口，可以生产手机 也可生产汽车
package com.zyx.factory.abstract_;

public interface AbstractFactory {
        Car getCar();
        Phone getPhone();
}
// 电工厂，专门生产 电类
class EleFactory implements AbstractFactory {
        @Override
        public Car getCar() {
                return new EleCar();
        }

        @Override
        public Phone getPhone() {
                return new ElePhone();
        }
}
// 油工厂，专门生产 油类
class GasFactory implements AbstractFactory {
        @Override
        public Car getCar() {
                return new GasCar();
        }

        @Override
        public Phone getPhone() {
                return new GasPhone();
        }
}
```
```java
// 测试类
package com.zyx.factory.abstract_;

public class MyTest {
        public static void main(String[] args) {
                EleFactory eleFactory = new EleFactory();
                eleFactory.getCar().getName();
                eleFactory.getPhone().call();

                GasFactory gasFactory = new GasFactory();
                gasFactory.getCar().getName();
                gasFactory.getPhone().call();
        }
}

```
