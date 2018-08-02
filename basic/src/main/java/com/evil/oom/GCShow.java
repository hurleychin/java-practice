package com.evil.oom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qinhulin on 2018-07-01
 */
public class GCShow {

    static class OOMObject{
        public byte[] placeholder=new byte[1024*1024]; //1Kb
    }

    public static void main(String[] a) throws InterruptedException, IOException {
        fillHeap(1000);
        System.gc();
        System.in.read();
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list=new ArrayList<>();
        for(int i=0;i<num;i++){ //每次填充64K
            Thread.sleep(1000);
            list.add(new OOMObject());
        }
    }
}
