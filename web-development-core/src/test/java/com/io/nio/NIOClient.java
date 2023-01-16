package com.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;


public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 获得一个SocketChannel通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置通道为非阻塞
        socketChannel.configureBlocking(false);
        // 获得多路复用器Selector
        Selector selector = Selector.open();
        // 客户端连接服务器,其实在后面的finishConnect方法中才正式连接
        socketChannel.connect(new InetSocketAddress(
                "127.0.0.1", 8030));
        // 将SocketChannel通道注册到Selector上，并给通道设置OP_CONNECT事件。
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        // 轮询访问selector
        while (true) {
            // 尝试获取事件，如果没有事件，会阻塞；有事件时方法返回
            selector.select();
            // 获得selector中SelectionKeys迭代器
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            // 遍历SelectionKey中的事件，挨个处理
            while (ite.hasNext()) {
                SelectionKey key = ite.next();
                ite.remove(); // 取出SelectionKey后，从迭代器中移出，防止重复执行
                if (key.isConnectable()) { // 连接事件
                    // 从SelectionKey中取得通道
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 如果正在连接，则完成连接
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    // 给服务器发送信息(也可以不发)
                    channel.write(ByteBuffer.wrap(
                            "生日快乐！".getBytes("utf-8")));
                    // 为了可以接收到服务端的信息，需要给通道设置可读权限。
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) { // 可读事件
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 分配缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 将数据读到缓冲区
                    channel.read(buffer);
                    // 将数据从缓冲区取出
                    byte[] data = Arrays.copyOf(buffer.array(), buffer.position());
                    String msg = new String(data);
                    System.out.println("客户端收到信息：" + msg);
                }
            }
        }
    }
}
