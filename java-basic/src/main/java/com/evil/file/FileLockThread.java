package com.evil.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

@Slf4j
public class FileLockThread extends Thread {

    private String lockName;
    private Runnable runnable;


    FileLockThread(String lockName, Runnable runnable) {
        this.lockName = lockName;
        this.runnable = runnable;
    }


    @Override
    public void run() {
        if (null != runnable) {

            FileLock lock = null;
            try {
                String filePath = System.getProperty("user.home", "c:") + File.separator + lockName;

                RandomAccessFile file = new RandomAccessFile(filePath, "rw");

                lock = file.getChannel().lock();
                if (null != lock) {
                    runnable.run();
                }
            } catch (Throwable e) {
                log.error("",e);
            } finally {
                try {
                    if (null != lock) {
                        lock.release();
                    }
                } catch (IOException e) {
                    log.error("",e);
                }
            }
        }

    }


    public static void main(String[] args) {

        FileLockThread lockThread = new FileLockThread(".boh_upload.lock", new Runnable() {
            @Override
            public void run() {
                for (int i = 30; i > 0; i--) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        lockThread.start();
        System.out.println("no wait1! ");
    }


}
