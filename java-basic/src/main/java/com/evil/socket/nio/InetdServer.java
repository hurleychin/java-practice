package com.evil.socket.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOptions;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class InetdServer {
    public static void main(String[] args) throws IOException {

        final int ECHO=7;
        final int DISCARD=9;

        //A selectable channel for stream-oriented listening sockets.
        ServerSocketChannel echo = ServerSocketChannel.open();
        echo.bind(new InetSocketAddress(ECHO));
        echo.configureBlocking(false);

        ServerSocketChannel discard = ServerSocketChannel.open();
        discard.bind(new InetSocketAddress(DISCARD));
        discard.configureBlocking(false);

        //A multiplexor of SelectableChannel objects.
        Selector selector = Selector.open();

        //Registers this channel with the given selector

        echo.register(selector, SelectionKey.OP_ACCEPT);
        discard.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int readyChannel=selector.selectNow();
            if(0==readyChannel)
                continue;

            //Returns this selector's selected-key set.
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();

                if(key.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

                    SocketChannel socketChanel = serverSocketChannel.accept();

                    socketChanel.configureBlocking(false);
                    socketChanel.register(selector,SelectionKey.OP_READ);
                    System.out.println("New client connected from "+socketChanel.getRemoteAddress());

                }else if(key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer=ByteBuffer.allocate(1024);

                    int read = socketChannel.read(buffer);

                    if(-1==read){
                        socketChannel.close();
                        continue;
                    }

                    buffer.flip();

                    byte[] data=new byte[buffer.limit()];
                    buffer.get(data);

                    System.out.println("Received client message:"+new String(data));


                    if(ECHO==((InetSocketAddress)socketChannel.getLocalAddress()).getPort()){
                        socketChannel.write(ByteBuffer.wrap(data));
                    }

                    if(DISCARD==((InetSocketAddress)socketChannel.getLocalAddress()).getPort()){
                        //Discard msg
                    }

                }

            }
        }

    }
}
