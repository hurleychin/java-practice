package com.evil.nio;

import com.evil.util.Console;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author qinhulin
 * @date 2020-08-10
 */
public class NioServer {
    public static void main(String[] args) throws IOException {

        //创建一个Selector
        Selector selector=Selector.open();

        //初始化TCP监听链接通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer=ByteBuffer.allocate(128);

        while (true){
            selector.select();
            Iterator<SelectionKey> keyIterator=selector.selectedKeys().iterator();

            while(keyIterator.hasNext()){
                SelectionKey key=keyIterator.next();

                if(key.isAcceptable()){
                    SocketChannel channel=((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);

                    Console.out("与"+channel.getRemoteAddress()+"建立了连接");
                }else if(key.isReadable()){
                    buffer.clear();

                    if(((SocketChannel)key.channel()).read(buffer)==-1){
                        key.channel().close();
                        continue;
                    }

                    buffer.flip();
                    while (buffer.hasRemaining()){
                        byte b=buffer.get();
                        if(b==0){
                            System.out.println();

                            buffer.clear();
                            buffer.put("Hello Client!\0".getBytes());
                            buffer.flip();
                            while (buffer.hasRemaining()){
                                ((SocketChannel) key.channel()).write(buffer);
                            }
                        }else {
                           System.out.print((char)b);
                        }
                    }
                }

               keyIterator.remove();
            }
        }


    }
}
