# 适配器模式 🐂🍺

## 适配器目的
适配器模式（有时候也称包装样式或者包装）将一个类的接口适配成用户所期待的。一个适配允许通常因为接口不兼容而不能在一起工作的类工作在一起，做法是将类自己的接口包裹在一个已存在的类中 。
比如手机充电器，交流电220V需要转为直流电5V，故需要添加一个适配器类，组合原本的接口，对外暴露变化后的直流电。

## 适用场景
1. 系统需要使用现有的类，但现有的类却不兼容。
2. 需要建立一个可以重复使用的类，用于一些彼此关系不大的类，并易于扩展，以便于面对将来会出现的类。
3. 需要一个统一的输出接口，但是输入类型却不可预知。
## 代码实现
```java
package com.zyx.adapter;

// 原本的插座
public class Socket {

    public int charge(){
        return 220;
    }

    public static void main(String[] args) {
        Socket socket = new Socket();
        Connector connector = new Connector(socket);
        System.out.println(connector.exchange());
    }
}

// 手机链接线 将220V的电压降为5V的操作
class Connector {
    private Socket socket;

    public Connector(Socket socket) {
        this.socket = socket;
    }

    public int exchange(){
        // 转换的逻辑操作
        int origin = socket.charge();
        return origin / 44;
    }
}
```
