package com.evil.io.echoserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qinhulin on 2020-11-11
 */
public class BIOEchoServer {
    private final static int port = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        BufferedInputStream in = new BufferedInputStream(
                                socket.getInputStream());
                        byte[] buf = new byte[1024];
                        int len = in.read(buf); // read message from client
                        String message = new String(buf, 0, len);
                        BufferedOutputStream out = new BufferedOutputStream(
                                socket.getOutputStream());
                        out.write(message.getBytes()); // echo to client
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
