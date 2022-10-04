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
