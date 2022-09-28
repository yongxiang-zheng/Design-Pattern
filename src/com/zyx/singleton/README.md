# 单例模式 🐂🍺
1. 为什么需要使用单例模式？<br>
   1. 因为有一些对象的创建和销毁开销比较大，可以重复使用来避免开销，比如数据库链接池采用单例模式，节省打开或者关闭数据库连接所引起的效率损耗。
2. Java中如何实现单例模式？<br>
   1. 八种方式（饿汉、懒汉、DCL、静态内部类、枚举）
3. 单例模式需要考虑的三个指标：
   1. 是否为懒加载
   2. 是否线程安全
   3. 是否可以被反射破解
## 1. 饿汉式-静态常量
```java
package com.zyx.singleton;
// 开销大，如果对象未被使用，也会创建
public class Hungry {
    // 私有构造器
    private Hungry(){
    }
    // 内部创建对象
    private static final Hungry hungry = new Hungry();

    // 提供公用静态方法
    public static Hungry getHungry() {
        return hungry;
    }
    // 测试
    public static void main(String[] args) {
        System.out.println(Hungry.getHungry().hashCode());
        System.out.println(Hungry.getHungry().hashCode());
    }
}
```
## 2. 饿汉式-静态代码块
```java
package com.zyx.singleton;
// 开销大，如果对象未被使用，也会创建
public class Hungry2 {
    private static Hungry2 hungry2;

    private Hungry2(){

    }

    static {
        hungry2 = new Hungry2();
    }

    public static Hungry2 getHungry2() {
        return hungry2;
    }

    public static void main(String[] args) {
        Hungry2 hungry_01 = Hungry2.getHungry2();
        Hungry2 hungry_02 = Hungry2.getHungry2();
        System.out.println(hungry_01.hashCode());
        System.out.println(hungry_02.hashCode());
    }
}

```
## 3. 懒汉式-01
懒加载、线程不安全（多个线程可以同时进入getLazy()方法）、可以被反射破解
```java
package com.zyx.singleton;

// 线程不安全懒汉式
public class Lazy01 {
    // 私有构造器
    private Lazy01(){
    }
    // 初始化对象
    private static Lazy01 lazy;
    // 静态公共方法创建对象
    public static Lazy01 getLazy() {
        if(lazy == null){
            lazy = new Lazy01();
        }
        return lazy;
    }
    // 测试
    public static void main(String[] args) {
        System.out.println(Lazy01.getLazy().hashCode());
        System.out.println(Lazy01.getLazy().hashCode());
    }
}
```
## 4. 懒汉式-02
针对懒汉式-01进行改进，对于getLazy02()方法进行加锁，但是其开销比较大，因为我们只希望在创建对象的时候加锁，而非对所有来获取对象的线程进行加锁，影响效率。
```java
package com.zyx.singleton;

// 线程安全懒汉式
public class Lazy02 {
    private static Lazy02 lazy02;

    private Lazy02(){

    }

    public synchronized static Lazy02 getLazy02() {
        if(lazy02 == null){
            lazy02 = new Lazy02();
        }
        return lazy02;
    }

    public static void main(String[] args) {
        System.out.println(Lazy02.getLazy02().hashCode());
        System.out.println(Lazy02.getLazy02().hashCode());
    }
}

```
## 5. 懒汉式-03
针对懒汉式-02进行改进，当创建对象时才加锁，但是当有A、B线程都进入了
if(lazy03 == null){} 代码块中，当A创建了对象，此时B获得了锁，也会进行对象的创建
，不能保障线程安全
```java
package com.zyx.singleton;

public class Lazy03 {
    private static Lazy03 lazy03;

    private Lazy03(){

    }

    public static Lazy03 getLazy03() {
        if(lazy03 == null){
            synchronized (Lazy03.class){
                lazy03 = new Lazy03();
            }
        }
        return lazy03;
    }

    public static void main(String[] args) {
        System.out.println(Lazy03.getLazy03().hashCode());
        System.out.println(Lazy03.getLazy03().hashCode());
    }
}
```
## 6. DCL
在加锁操作中继续加入判空操作，防止对象的重复创建，并且为了避免指令重排造成的影响，对于对象加入volatile保证可见性
```java
package com.zyx.singleton;

public class DCL {
    private static volatile DCL dcl;

    private DCL(){

    }

    public static DCL getDCL(){
        if(dcl == null){
            synchronized (DCL.class){
                if(dcl == null){
                    dcl = new DCL();
                }
            }
        }
        return dcl;
    }
}
```
## 7. 静态内部类
线程安全，只有调用的时候才会创建内部类，实现了懒加载机制
```java
package com.zyx.singleton;

public class InnerClass {
    private InnerClass(){

    }
    private static class TempClass{
        private static final InnerClass innerClass = new InnerClass();
    }

    public static InnerClass getInnerClass(){
        return TempClass.innerClass;
    }
}

```
## 8. 枚举
无法通过反射破解
```java
package com.zyx.singleton;

public enum EmuClass {
    INSTANCE;
}
```
